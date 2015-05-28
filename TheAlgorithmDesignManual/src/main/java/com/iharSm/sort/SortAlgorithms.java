package com.iharSm.sort;

import java.util.List;
import java.util.function.Function;

class SortAlgorithms<T> {

	public int[] sort(int[] input, Function<int[], int[]> method) {

		return method.apply(input);
	}

	public List<T> sort(List<T> input, Function<List<T>, List<T>> method) {

		return method.apply(input);
	}

}
