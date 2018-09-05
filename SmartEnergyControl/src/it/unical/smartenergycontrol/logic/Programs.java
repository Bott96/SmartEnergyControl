package it.unical.smartenergycontrol.logic;

public class Programs {

	boolean SmartControl = false; // 0
	boolean TimeControl = false; // 1
	boolean ManualControl = false; // 2
	boolean MoreThanOne = false; // 3

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
		return SmartControl && !(TimeControl || ManualControl || MoreThanOne);
	}

	public boolean isTimeControl() {
		return TimeControl && !(SmartControl || ManualControl || MoreThanOne);
	}

	public boolean isManualControl() {
		return ManualControl && !(TimeControl || SmartControl || MoreThanOne);
	}

	public boolean isMoreThanOne() {
		return MoreThanOne && !(TimeControl || SmartControl || ManualControl);
	}

	public void setPorgrams(int P) {
		//
		if (P == 0) {
			SmartControl = true;
			TimeControl = false;
			ManualControl = false;
			MoreThanOne = false;
		} else if (P == 1) {

			SmartControl = false;
			TimeControl = true;
			ManualControl = false;
			MoreThanOne = false;
		} else if (P == 2) {

			SmartControl = false;
			TimeControl = false;
			ManualControl = true;
			MoreThanOne = false;
		} else if (P == 3) {

			SmartControl = false;
			TimeControl = false;
			ManualControl = false;
			MoreThanOne = true;
		} else {
			SmartControl = false;
			TimeControl = false;
			ManualControl = false;
			MoreThanOne = false;
		}

	}

}
