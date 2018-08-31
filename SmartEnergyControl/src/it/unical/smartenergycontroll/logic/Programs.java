package it.unical.smartenergycontroll.logic;

public class Programs {

	boolean SmartControll = false; // 0
	boolean TimeControll = false; // 1
	boolean ManualControll = false; // 2

	private static Programs programs = null;

	private Programs() {

	}

	public static Programs getInstance() {
		if (programs == null) {
			programs = new Programs();
		}
		return programs;

	}

	public boolean isSmatControll() {
		return SmartControll && !(TimeControll || ManualControll);
	}

	public boolean isTimeControll() {
		return TimeControll && !(SmartControll || ManualControll);
	}

	public boolean isManualControll() {
		return ManualControll && !(TimeControll || SmartControll);
	}

	public void setPorgrams(int P) {
		//
		if (P == 0) {
			SmartControll = true;
			TimeControll = false;
			ManualControll = false;
		} else if (P == 1) {

			SmartControll = false;
			TimeControll = true;
			ManualControll = false;
		} else {

			SmartControll = false;
			TimeControll = false;
			ManualControll = true;
		}

	}

}
