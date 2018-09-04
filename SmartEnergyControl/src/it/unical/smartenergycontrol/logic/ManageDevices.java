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

	public void sortPriority() {

		devices.sort(PriorityDeviceComparator);

	}

	public int sumTotalKw() {

		int sum = 0;
		for (int i = 0; i < devices.size(); i++) {
			sum += devices.get(i).getMaxKW();
		}

		return sum;

	}

	public void sortKW() {

		devices.sort(KWDeviceComparator);

	}

	public Comparator<Device> PriorityDeviceComparator = new Comparator<Device>() {

		public int compare(Device dev1, Device dev2) {

			Integer pri1 = dev1.getPriority();
			Integer pri2 = dev2.getPriority();

			return pri1.compareTo(pri2);

		}

	};

	public Comparator<Device> KWDeviceComparator = new Comparator<Device>() {

		public int compare(Device dev1, Device dev2) {

			Integer kw1 = dev1.getMaxKW();
			Integer kw2 = dev2.getMaxKW();

			return kw1.compareTo(kw2);

		}

	};

	private int getDev(int i) {
		return devices.get(i).getPriority();
	}

	public static void main(String[] args) {

		ManageDevices md = new ManageDevices();
		md.AddDevice(11, "asd", 300, 3);
		md.AddDevice(12, "asd", 800, 1);
		md.AddDevice(13, "asd", 2200, 2);

		System.out.println(md.deviceICanOpenEc(1200));

	}

	public ArrayList<Integer> deviceICanOpenEc(int maxKw) {

		ArrayList<Integer> sol = new ArrayList<>();
		decision = new ScheletroBactracking(devices, maxKw, sol);

		decision.TemplateMethod_Solve(0);
	//	System.out.println(decision.SommaMax);
		//System.out.println(decision.BestSol);

		return decision.BestSol;

	}

}