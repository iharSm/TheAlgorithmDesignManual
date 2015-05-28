package com.iharSm.sort;

import java.util.ArrayList;
import java.util.List;

public class SortMethods {

	public static int[] insertionSort(int[] input) {
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

	public static List<Integer> mergeSort(List<Integer> input) {
		return mergeSort(input, 0, input.size() - 1);
	}

	private static List<Integer> mergeSort(List<Integer> input, int start,
			int end) {

		int p = (end - start) / 2;
		if (p > 0) {
			mergeSort(input, start, start + p - 1);
			mergeSort(input, start + p, end);

			int i = 0;
			int j = 0;
			int pos = start;
			List<Integer> left = new ArrayList<Integer>(input.subList(start,
					start + p));
			List<Integer> right = new ArrayList<Integer>(input.subList(start
					+ p, end + 1));

			while (i < left.size() && j < right.size()) {
				if (left.get(i).intValue() > right.get(j).intValue()) {
					input.set(pos++, right.get(j++));
				} else {
					input.set(pos++, right.get(i++));
				}
			}
			while (i < left.size())
				input.set(pos++, left.get(i++));
			while (j < right.size())
				input.set(pos++, right.get(j++));

		} else {
			if (input.get(start).intValue() > input.get(end).intValue()) {
				Integer temp = input.get(start);
				input.set(start, input.get(end));
				input.set(end, temp);
			}
		}

		return input;
	}

}
