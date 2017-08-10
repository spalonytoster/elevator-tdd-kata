package com.comarch.tdd;

public class FloorSensor {
	
	private FloorMonitor floorMonitor;

	public void fire(int floor) {
		floorMonitor.setCurrentFloor(floor);
	}
	
	public void setFloorMonitor(FloorMonitor floorMonitor) {
		this.floorMonitor = floorMonitor;
	}
}
