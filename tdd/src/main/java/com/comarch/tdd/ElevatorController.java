package com.comarch.tdd;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

	private List<Integer> requests;
	private final int bottomRange;
	private final int upperRange;
	private RequestsOptimizer requestOptimizer;

	public ElevatorController(int bottomRange, int upperRange) {
		this.requests = new ArrayList<Integer>();
		this.bottomRange = bottomRange;
		this.upperRange = upperRange;
		this.requestOptimizer = new DefaultRequestsOptimizer();
	}

	public void callOutside(int targetFloor) {
		addRequest(targetFloor);
	}

	public void callInside(int targetFloor) {
		addRequest(targetFloor);
	}

	private void addRequest(int floor) {
		if (validateRequest(floor)) {
			requests.add(floor);
		}
	}

	public List<Integer> getRequests() {
		return requestOptimizer.optimizeRequests(requests);
	}

	private boolean validateRequest(int floor) {
		return validateUniqueRequest(floor) && validateInRange(floor);
	}

	private boolean validateUniqueRequest(int floor) {
		return !requests.contains(floor);
	}
	
	private boolean validateInRange(int floor) {
		return floor >= bottomRange && floor <= upperRange;
	}
	
	public void setRequestOptimizer(RequestsOptimizer requestOptimizer) {
		this.requestOptimizer = requestOptimizer;
	}
}
