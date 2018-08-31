package it.unical.smartenergycontroll.logic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import it.unical.smartenergycontroll.gui.myFrame;

public class Controller {
	final static private int ROUND = 2;

	myFrame frame;
	SerialArduinoConnection SAC;
	SerialComunicationTelosB STC;
	public Lock lock = new ReentrantLock();
	public Condition c = lock.newCondition();

	public Controller(myFrame frame) {
		this.frame = frame;

	}

	public void startTelosbConnection(String connectionPort) {
		STC = new SerialComunicationTelosB(connectionPort, frame);

	}

	public void startArduinoConnection(String connectionPort) {
		SAC = new SerialArduinoConnection(connectionPort, frame);

	}

	public void dataARDUINOturnOn() {
		SAC.writeData(49);
	}

	public void dataARDUINOturnOff() {
		SAC.writeData(50);
	}

	public void smartOpenProgram(int userThreeshold) {

		Programs.getInstance().setPorgrams(0);

		new Thread() {

			boolean justOpen = false;
			boolean justClosed = false;
			int oldMisure = 0;
			int count = ROUND;

			@Override
			public void run() {

				while (Programs.getInstance().SmartControll) {

					lock.lock();
					// System.out.println(Programs.getInstance().SmartControll);
					try {

						while (STC.getData() < userThreeshold && count != 0) {
							count--;
							System.out.println("Mi fermo quo");
							c.await();

						}

						if (STC.getData() > userThreeshold && count > 0 && !justOpen) {
							SAC.writeData(49);
							System.out.println("SCRIVO SU ARDUINO");
							justOpen = true;
							oldMisure = STC.getData();
						}

						if (count == 0) {
							SAC.writeData(50);
							System.out.println("SCRIVO SU ARDUINO");
							justClosed = true;
							justOpen = false;
							count = ROUND;
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

				frame.getApplicationFrame().lblProgram.setText(" Off ");

			}

		}.start();

	}

}
