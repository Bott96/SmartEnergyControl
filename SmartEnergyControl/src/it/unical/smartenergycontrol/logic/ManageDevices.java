package it.unical.smartenergycontrol.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ManageDevices {

	public final static int OFFSET = 11;

	ArrayList<Device> devices;

	ScheletroBactracking decision;

	public ManageDevices() {
		devices = new ArrayList<>(3);
		devices.add(null);
		devices.add(null);
		devices.add(null);
		devices.set(0, new Device(50, " ", 5000000, 0, false));
		devices.set(1, new Device(51, " ", 5000000, 0, false));
		devices.set(2, new Device(52, " ", 5000000, 0, false));

	}

	public void AddDevice(int port, String name, int maxKW, int priority) {

		devices.set(port - OFFSET, new Device(port, name, maxKW, priority, false));
	}

	public Device getMaxKW() {

		int c = 0;
		int max = devices.get(c).getMaxKW();
		for (int i = 1; i < devices.size(); i++) {
			if (max < devices.get(i).getMaxKW()) {
				c = 1;
			}
		}

		return devices.get(c);

	}

	public List<Device> getDevices() {
		return devices;
	}

	public Device getDevBestPriority() {
		int c = 0;
		int max = devices.get(c).getPriority();
		for (int i = 1; i < devices.size(); i++) {
			if (max < devices.get(i).getPriority()) {
				c = 1;
			}
		}

		return devices.get(c);

	}






	private int getDev(int i) {
		return devices.get(i).getPriority();
	}

	public static void main(String[] args) {

		ManageDevices md = new ManageDevices();
		md.AddDevice(11, "asd", 200, 1);
		md.AddDevice(12, "asd", 500, 2);
		md.AddDevice(13, "asd", 1500, 3);

		System.out.println(md.deviceICanOpenEc(1500));

	}

	public ArrayList<Device> deviceICanOpenEc(int maxKw) {

		ArrayList<Device> sol = new ArrayList<>();
		decision = new ScheletroBactracking(devices, maxKw, sol);

		decision.TemplateMethod_Solve(0);

		return decision.BestSol;

	}

	public void reset() {
		devices.set(0, new Device(50, " ", 5000000, 0, false));
		devices.set(1, new Device(51, " ", 5000000, 0, false));
		devices.set(2, new Device(52, " ", 5000000, 0, false));

	}

}