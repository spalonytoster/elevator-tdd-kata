package com.comarch.tdd;

import org.junit.Test;
import org.mockito.Mockito;

public class FloorSensorTest {

	@Test
	public void shouldDisplayFloorOnMonitor() {
		FloorSensor floorSensor = new FloorSensor();
		FloorMonitor floorMonitorMock = Mockito.mock(FloorMonitor.class);
		floorSensor.setFloorMonitor(floorMonitorMock);
		
		floorSensor.fire(5);
		
		Mockito.verify(floorMonitorMock).setCurrentFloor(5);
	}
}
