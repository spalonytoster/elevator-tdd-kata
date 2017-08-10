package com.comarch.tdd;

import java.util.ArrayList;
import java.util.List;

public class AscendingOrderRequestsOptimizer implements RequestsOptimizer {

	@Override
	public List<Integer> optimizeRequests(List<Integer> requests) {
		List<Integer> sortedRequests = new ArrayList<>(requests);
		sortedRequests.sort(Integer::compareTo);
		return sortedRequests;
	}
}


// https://github.com/spalonytoster/elevator-tdd-kata.git