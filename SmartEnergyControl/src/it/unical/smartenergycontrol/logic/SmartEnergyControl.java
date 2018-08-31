package it.unical.smartenergycontrol.logic;

import it.unical.smartenergycontrol.gui.ApplicationFrame;
import it.unical.smartenergycontrol.gui.myFrame;

public class SmartEnergyControl {
	public static void main(String[] args) {

		ApplicationFrame a = new ApplicationFrame();
		a.setVisible(false);

		myFrame m = new myFrame(a);
		m.setVisible(true);
		m.setFocusable(true);

	}

}
