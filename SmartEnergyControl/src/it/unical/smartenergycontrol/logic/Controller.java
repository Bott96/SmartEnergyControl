package it.unical.smartenergycontrol.logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import it.unical.smartenergycontrol.gui.myFrame;

public class Controller {
	final static private int ROUND = 2;
	final static private int ROUNDTOOPEN = 2;

	myFrame frame;
	SerialArduinoConnection SAC;
	SerialComunicationTelosB STC;
	public Lock lock = new ReentrantLock();
	public Condition c = lock.newCondition();
	public static boolean firstTime = true;
	public static boolean justUpdate = false;
	public static boolean isAccumulatorOpen = false;
	public ManageDevices managerDevice = new ManageDevices();

	public Controller(myFrame frame) {
		this.frame = frame;
	}

	public void startTelosbConnection(String connectionPort) {
		STC = new SerialComunicationTelosB(connectionPort, frame);

	}

	public void startArduinoConnection(String connectionPort) {
		SAC = new SerialArduinoConnection(connectionPort, frame);

	}

	public void dataARDUINOturnOnProgram0() {
		SAC.writeData(49);
	}

	public void dataARDUINOturnOffProgram0() {
		SAC.writeData(50);
	}

	public void dataARDUINOturnOnProgram1() {
		SAC.writeData(149);
	}

	public void dataARDUINOturnOffProgram1() {
		SAC.writeData(150);
	}

	public void dataARDUINOturnOnProgram2() {
		SAC.writeData(249);
	}

	public void dataARDUINOturnOffProgram2() {
		SAC.writeData(250);
	}

	public void dataARDUINOReset() {
		SAC.writeData(999);
		firstTime = true;
		frame.getApplicationFrame().plsONOFF.setText("Manual On");

		dataARDUINOturnOffProgram0();
		dataARDUINOturnOffProgram1();
		dataARDUINOturnOffProgram2();

	}

	public void manualControl() {

		Programs.getInstance().setPorgrams(2);
		SAC.writeData(2);

		if (Programs.getInstance().isManualControl() && !firstTime) {
			dataARDUINOturnOffProgram2();
			firstTime = true;
			isAccumulatorOpen = false;
			frame.getApplicationFrame().plsONOFF.setText("Manual On");

			Programs.getInstance().setPorgrams(7);
		} else {
			dataARDUINOturnOnProgram2();
			isAccumulatorOpen = true;

			frame.getApplicationFrame().plsONOFF.setText("Manual Off");
			firstTime = false;
		}
	}

	public void timeControl(String[] hmUP, String[] hmDOWN) {
		firstTime = true;
		Programs.getInstance().setPorgrams(1);
		SAC.writeData(1);

		Timer timer = new Timer();

		System.out.println("AVVIO LO SCHEDULE");
		try {
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date dateUp = dateFormatter.parse(java.time.LocalDate.now() + " " + hmUP[0] + ":" + hmUP[1] + ":00");

			Date dateDown = dateFormatter.parse(java.time.LocalDate.now() + " " + hmDOWN[0] + ":" + hmDOWN[1] + ":00");

			dataARDUINOturnOffProgram1();
			frame.getApplicationFrame().plsONOFF.setText("Manual On");

			timer.schedule(new MyTimeTaskUP(this), dateUp);
			isAccumulatorOpen = true;

			firstTime = false;
			timer.schedule(new MyTimeTaskDOWN(this), dateDown);

			// frame.getApplicationFrame().plsONOFF.setText("Manual On");
			isAccumulatorOpen = false;
			firstTime = true;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void smartOpenProgram(int userThreeshold) {
		firstTime = true;
		SAC.writeData(3);

		Programs.getInstance().setPorgrams(0);

		new Thread() {

			boolean justOpen = false;
			boolean justClosed = false;
			int oldMisure = 0;
			int count = ROUND;

			@Override
			public void run() {

				while (Programs.getInstance().SmartControl) {

					lock.lock();
					// System.out.println(Programs.getInstance().SmartControl);
					try {

						while (STC.getData() < userThreeshold && count != 0) {
							count--;
							System.out.println("Mi fermo quo");
							c.await();

						}

						if (STC.getData() > userThreeshold && count > 0 && !justOpen) {
							dataARDUINOturnOnProgram0();
							System.out.println("SCRIVO SU ARDUINO");
							justOpen = true;
							oldMisure = STC.getData();
							frame.getApplicationFrame().plsONOFF.setText("Manual Off");
							firstTime = false;
							isAccumulatorOpen = true;

						}

						if (count == 0) {
							dataARDUINOturnOffProgram0();
							System.out.println("SCRIVO SU ARDUINO");
							justClosed = true;
							justOpen = false;
							count = ROUND;
							frame.getApplicationFrame().plsONOFF.setText("Manual On");
							firstTime = true;
							isAccumulatorOpen = false;

						}
						while ((STC.getData() > oldMisure + 50 || STC.getData() < oldMisure - 50)
								&& STC.getData() < userThreeshold) { // se è true

							System.out.println("Maggiore  o minore old miuser");
							c.await();
						}

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					lock.unlock();
				}

			
			}

		}.start();

	}

	public void moreThanOneOpen(int Program) {

		if (Program == 1) { // economics

			new Thread() {

				boolean justOpen = false;
				int oldMisure = 0;
				int count = ROUNDTOOPEN;

				@Override
				public void run() {

					while (Programs.getInstance().MoreThanOne && Program == 1) {

						lock.lock();

						if (justUpdate == false) {
							justUpdate = true;
							oldMisure = STC.getData();
							ArrayList<Device> devToOpen = managerDevice.deviceICanOpenEc(STC.getData());
							System.out.println("VALORE SU CUI OPERAREEE  " + devToOpen);

						}
						System.out.println("VALORI PER CUI ESCO  ");
						System.out.println("OLD MISURE PIU " + (oldMisure+61));
						System.out.println("OLD MISURE MENO " + (oldMisure-61));
						System.out.println("GET DATA " + STC.getData());

						while (!(STC.getData() >= oldMisure + 100 || STC.getData() <= oldMisure - 100)) { // se è true

							System.out.println("Maggiore  o minore more tha one open");
							//System.out.println("PERCHE NON ESCO DAL QHILE?");

							//System.out.println("OLD MISURE " + oldMisure);
						//	System.out.println("GET DATA " + STC.getData());
							try {
								c.await();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						
						while(count !=0){
							
							count --;
							try {
								c.await();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
							
						
						}
						
						ArrayList<Device> devToOpen = managerDevice.deviceICanOpenEc(STC.getData());
						// DICI AD ARDUINO QUALI APRIRE
						System.out.println("VALORE SU CUI OPERAREEE  " + devToOpen);
						// oldMisure = STC.getData();
						// justUpdate = false;
						count = ROUNDTOOPEN;
						
						oldMisure = STC.getData();
						lock.unlock();

					}

				}

			}.start();

		}

	}

}

class MyTimeTaskUP extends TimerTask {

	Controller controller;

	public MyTimeTaskUP(Controller controller) {
		this.controller = controller;
	}

	public void run() {

		System.out.println("SCRIVO SU ARDUONì");
		controller.dataARDUINOturnOnProgram1();
		controller.frame.getApplicationFrame().plsONOFF.setText("Manual Off");
		controller.firstTime = false;

	}

}

class MyTimeTaskDOWN extends TimerTask {

	Controller controller;

	public MyTimeTaskDOWN(Controller controller) {
		this.controller = controller;
	}

	public void run() {

		System.out.println("SCRIVO SU ARDUONì");
		controller.dataARDUINOturnOffProgram1();
		controller.frame.getApplicationFrame().plsONOFF.setText("Manual On");
		controller.firstTime = true;

	}
}
