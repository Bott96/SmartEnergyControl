package it.unical.smartenergycontroll.logic;

import java.io.IOException;

import it.unical.smartenergycontroll.gui.ApplicationFrame;
import it.unical.smartenergycontroll.gui.myFrame;
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
	int c = 0;
	private int data;
	private int sum;

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

		int i = 20;
		sum += ((MyMessage) message).getCounter();
		c++;

		if (c == i) {
			System.out.println("Aggiorno");
			c = 0;
			data = sum / i;
			appFrame.lblShowData.setText(data + "");
			sum = 0;
			frame.getController().lock.lock();
			frame.getController().c.signalAll();

			frame.getController().lock.unlock();

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
