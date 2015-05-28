package com.iharSm.sort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class TestSortAlgorithms {

	@Test
	public void testInsertionSort() {
		SortAlgorithms<Integer> sortAlgos = new SortAlgorithms<Integer>();
		int[] input = { 9, 8, 7, 6, 5 };
		assertArrayEquals(sortAlgos.sort(input, SortMethods::insertionSort),
				new int[] { 5, 6, 7, 8, 9 });
	}

	@Test
	public void testMergeSort() {
		SortAlgorithms<Integer> sortAlgos = new SortAlgorithms<Integer>();
		List<Integer> input = new Vector<Integer>();
		input.addAll(Arrays.asList(9, 8, 7, 6, 5));
		List<Integer> output = sortAlgos.sort(input, SortMethods::mergeSort);
		int[] intArray = ArrayUtils.toPrimitive(output
				.toArray(new Integer[output.size()]));
		assertArrayEquals(intArray, new int[] { 5, 6, 7, 8, 9 });
	}

}
