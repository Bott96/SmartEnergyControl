package it.unical.smartenergycontrol.logic;

public class Programs {

	boolean SmartControl = false; // 0
	boolean TimeControl = false; // 1
	boolean ManualControl = false; // 2

	private static Programs programs = null;

	private Programs() {

	}

	public static Programs getInstance() {
		if (programs == null) {
			programs = new Programs();
		}
		return programs;

	}

	public boolean isSmartControl() {
		return SmartControl && !(TimeControl || ManualControl);
	}

	public boolean isTimeControl() {
		return TimeControl && !(SmartControl || ManualControl);
	}

	public boolean isManualControll() {
		return ManualControl && !(TimeControl || SmartControl);
	}

	public void setPorgrams(int P) {
		//
		if (P == 0) {
			SmartControl = true;
			TimeControl = false;
			ManualControl = false;
		} else if (P == 1) {

			SmartControl = false;
			TimeControl = true;
			ManualControl = false;
		} else if (P == 2) {

			SmartControl = false;
			TimeControl = false;
			ManualControl = true;
		} else {
			SmartControl = false;
			TimeControl = false;
			ManualControl = false;
		}

	}

}
