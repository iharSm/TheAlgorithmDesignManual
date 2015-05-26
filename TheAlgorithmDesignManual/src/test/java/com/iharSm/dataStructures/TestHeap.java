package com.iharSm.dataStructures;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestHeap {

	@Test
	public void testHeapInsert_Asc() {
		Heap<Integer> h = new Heap<Integer>(Integer.class, 5, (a, b) -> {
			return Integer.compare(a, b);
		});

		h.insert(10);
		h.insert(12);
		h.insert(9);

		assertTrue(h.heap[0] == 9);
		assertTrue (h.heap[1] == 10);
		assertTrue (h.heap[2] == 12);

	}
	
	@Test
	public void testHeapInsert_Dsc() {
		Heap<Integer> h = new Heap<Integer>(Integer.class, 5, (a, b) -> {
			return Integer.compare(b, a);
		});

		h.insert(10);
		h.insert(12);
		h.insert(9);

		assertTrue(h.heap[0] == 12);
		assertTrue (h.heap[1] == 10);
		assertTrue (h.heap[2] == 9);

	}
}
