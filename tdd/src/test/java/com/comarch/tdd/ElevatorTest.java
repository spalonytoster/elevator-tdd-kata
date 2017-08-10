package com.comarch.tdd;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ElevatorTest {

	private static final int BOTTOM_RANGE = -1;
	private static final int UPPER_RANGE = 10;
	private ElevatorController elevatorController;

	@Before
	public void init() {
		elevatorController = new ElevatorController(BOTTOM_RANGE, UPPER_RANGE);
	}

	@Test
	public void shouldAcceptWhenCalledOutside() {
		elevatorController.callOutside(5);

		List<Integer> result = elevatorController.getRequests();
		assertEquals(Arrays.asList(5), result);
	}

	@Test
	public void shouldAcceptWhenCalledInside() {
		elevatorController.callInside(5);

		List<Integer> result = elevatorController.getRequests();
		assertEquals(Arrays.asList(5), result);
	}

	@Test
	public void shouldAcceptSeveralRequests() {
		elevatorController.callInside(5);
		elevatorController.callOutside(9);
		elevatorController.callInside(7);
		elevatorController.callOutside(1);
		elevatorController.callInside(2);

		List<Integer> result = elevatorController.getRequests();
		assertEquals(Arrays.asList(5, 9, 7, 1, 2), result);
	}

	@Test
	public void shouldAcceptUniqueRequests() {
		elevatorController.callInside(5);
		elevatorController.callInside(5);
		elevatorController.callInside(5);

		List<Integer> result = elevatorController.getRequests();
		assertEquals(Arrays.asList(5), result);
	}

	@Test
	public void shouldAcceptRequestsInRange() {
		elevatorController.callInside(BOTTOM_RANGE - 1);
		elevatorController.callInside(5);
		elevatorController.callInside(UPPER_RANGE + 1);

		List<Integer> result = elevatorController.getRequests();
		assertEquals(Arrays.asList(5), result);
	}
}
