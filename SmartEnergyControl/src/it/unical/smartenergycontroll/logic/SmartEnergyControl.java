package it.unical.smartenergycontroll.logic;

import it.unical.smartenergycontroll.gui.ApplicationFrame;
import it.unical.smartenergycontroll.gui.myFrame;

public class SmartEnergyControl {
	public static void main(String[] args) {

		ApplicationFrame a = new ApplicationFrame();
		a.setVisible(false);

		myFrame m = new myFrame(a);
		m.setVisible(true);
		m.setFocusable(true);

	}

}
