package com.iharSm.sort;

import java.util.function.Function;
import java.util.Arrays;

class SortAlgorithms {

	public int[] sort(int[] input, Function<int[], int[]> method) {

		return method.apply(input);
	}

	public static void main(String[] args) {

		SortAlgorithms sortAlgos = new SortAlgorithms();
		SortMethods sortMethods = sortAlgos.new SortMethods();
		int[] input = { 9, 8, 7, 6, 5 };
		System.out.println(Arrays.toString(sortAlgos.sort(input,
				sortMethods::insertionSort)));
	}

	class SortMethods {
		public int[] insertionSort(int[] input) {
			int j;

			for (int i = 1; i < input.length; i++) {
				j = i;
				while ((j > 0) && (input[j - 1] > input[j])) {
					int temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;

					j--;
				}

			}
			return input;
		}

	}

}
