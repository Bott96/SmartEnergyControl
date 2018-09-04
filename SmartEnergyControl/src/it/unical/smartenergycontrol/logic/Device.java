package it.unical.smartenergycontrol.logic;

public class Device implements Comparable<Device> {

	private int port;
	private String Name;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	private int MaxKW;
	private Integer Priority;
	boolean isOpen;

	public Device() {
	}

	public Device(int port, String name, int maxKW, int priority, boolean isOpen) {
		super();
		this.port = port;
		Name = name;
		MaxKW = maxKW;
		Priority = priority;
		this.isOpen = isOpen;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getMaxKW() {
		return MaxKW;
	}

	public void setMaxKW(int maxKW) {
		MaxKW = maxKW;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	@Override
	public int compareTo(Device o) {

		return this.getPriority() - o.getPriority();
	}

	@Override
	public String toString() {
		return this.Name + " " + this.MaxKW + " PRI->" + this.Priority + " PORT->" + this.port;
	}

}
