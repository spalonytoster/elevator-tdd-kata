package com.comarch.tdd;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class AscendingOrderOptimizerTest {

	@Test
	public void shouldOptimizeRequests() {
		RequestsOptimizer requestOptimizer = new AscendingOrderRequestsOptimizer();

		List<Integer> result = requestOptimizer.optimizeRequests(Arrays.asList(1, 4, 5, 2));

		assertEquals(Arrays.asList(1, 2, 4, 5), result);
	}
}
