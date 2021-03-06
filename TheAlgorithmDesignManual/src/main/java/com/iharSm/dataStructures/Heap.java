package com.iharSm.dataStructures;

import java.lang.reflect.Array;

class Heap<T> {

	public T[] heap;
	int numberOfElements;
	Comparator<T> tester;

	public Heap(Class<T> c, int size, Comparator<T> tester) {

		@SuppressWarnings("unchecked")
		final T[] a = (T[]) Array.newInstance(c, size);
		this.heap = a;
		this.tester = tester;

	}

	public int getParentPosition(int n) {
		if (n == 0)
			return -1;
		return n / 2;
	}

	public int getLeftChildPosition(int n) {
		return 2 * n + 1;
	}

	public int getRightChildPosition(int n) {
		return 2 * n + 2;
	}

	private void insert(T t, int position) {
		if (getParentPosition(position) != -1
				&& this.tester.compare(heap[getParentPosition(position)], t) > 0 ) {
			heap[position] = heap[getParentPosition(position)];
			insert(t, getParentPosition(position));
		} else {
			heap[position] = t;
		}

	}

	public void insert(T t) {
		this.insert(t, this.numberOfElements);
		this.numberOfElements++;

	}

	public void makeHeap(T[] t) {

		for (T i : t)
			insert(i);
	}
	

	public T heapify() {
		if (this.numberOfElements == 0)
			return null;

		T root = heap[0];
		this.numberOfElements--;
		heap[0] = heap[this.numberOfElements];
		heap[this.numberOfElements] = null;
		bubbleDown(0);

		return root;
	}

	public void bubbleDown(int pos) {

		int min = pos;
		int left = this.getLeftChildPosition(pos);
		for (int i = 0; i <= 1; i++) {
			if (left + i < this.numberOfElements) {
				if (this.tester.compare(this.heap[min], this.heap[left + i]) > 0)
					min = left + i;
			}
		}

		if (min != pos) {
			T temp = this.heap[pos];
			this.heap[pos] = this.heap[min];
			this.heap[min] = temp;

			bubbleDown(min);
		}
	}

	interface Comparator<T> {
		public int compare(T a, T b);
	}

}