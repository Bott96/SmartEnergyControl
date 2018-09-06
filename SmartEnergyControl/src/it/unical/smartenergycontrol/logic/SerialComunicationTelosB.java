package it.unical.smartenergycontrol.logic;

import java.io.IOException;

import it.unical.smartenergycontrol.gui.ApplicationFrame;
import it.unical.smartenergycontrol.gui.myFrame;
import net.tinyos.message.Message;
import net.tinyos.message.MessageListener;
import net.tinyos.message.MoteIF;
import net.tinyos.packet.BuildSource;
import net.tinyos.packet.PhoenixSource;
import net.tinyos.util.PrintStreamMessenger;

public class SerialComunicationTelosB implements MessageListener {
	PhoenixSource ps;
	MoteIF mote;
	myFrame frame;
	ApplicationFrame appFrame;
	int c = 1;
	int k = 1;

	int i = 20;
	int j = 5;
	private int data;
	private int sum;;
	private int sum1;

	public SerialComunicationTelosB(String ConnectionPort, myFrame frame) {
		this.frame = frame;
		appFrame = frame.getApplicationFrame();
		ps = BuildSource.makePhoenix("serial@" + ConnectionPort + ":telosb", PrintStreamMessenger.out);
		mote = new MoteIF(ps);

		mote.registerListener(new MyMessage(), this);
		frame.lblTelosbResponce.setText("TELOSB CONNECTED");
		System.out.println("TELOSB CONNECTED");

	}

	@Override
	public void messageReceived(int arg0, Message message) {

		sum += ((MyMessage) message).getCounter();
		c++;
		/**
		 * k++; CURRENT SENSOR
		 * 
		 * if (k == j) { sum1 += sum; k = 1; sum = 0; }
		 */

		if (c == i) {

			/** int ValToPrint = ((sum1 / 100) * 30); CURRENT SENSOR **/

			System.out.println("Aggiorno /sveglio");
			c = 1;
			data = sum / i;
			/** data = sum1 / j; CURRENT SENSOR **/
			/** data = (data1/100)*62; CURRENT SENSOR **/
			/** data = ValToPrint; **/
			appFrame.lblShowData.setText(data + "");

			frame.getApplicationFrame().getMoreThanOneFrame().lblShowData.setText(data + "");

			Config.controller.lock.lock();
			Config.controller.c.signalAll();

			Config.controller.lock.unlock();
			sum1 = 0;
			sum = 0;
		}
		System.out.println(
				"DA CHI  " + ((MyMessage) message).getNodeId() + "   counter" + ((MyMessage) message).getCounter());
	}

	private void send() {
		int counter = 0;

		MyMessage m = new MyMessage();

		// while (true) {
		// System.out.println("Sending packet " + counter);

		try {
			MyMessage mex = new MyMessage(32);
			mex.setCounter(0, 16, 1);
			mex.setCounter(16, 16, 11);
			System.out.println("INVIO");
			// moteID, MEX
			mote.send(1, mex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }

	}

	public int getData() {
		return data;
	}

	public static void main(String[] args) {
		// SerialComunicationTelosB SC = new SerialComunicationTelosB("/dev/ttyUSB0");
		// SC.send();

	}

}
