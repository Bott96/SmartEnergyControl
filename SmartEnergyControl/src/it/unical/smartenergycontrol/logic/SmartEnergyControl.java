package it.unical.smartenergycontrol.logic;

import java.awt.Dimension;

import it.unical.smartenergycontrol.gui.myFrame;

public class SmartEnergyControl {
	public static void main(String[] args) {

		myFrame m = new myFrame();
		m.getContentPane().setPreferredSize(new Dimension(600, 800));
		m.pack();
		m.setVisible(true);
		m.setFocusable(true);

	}

}
