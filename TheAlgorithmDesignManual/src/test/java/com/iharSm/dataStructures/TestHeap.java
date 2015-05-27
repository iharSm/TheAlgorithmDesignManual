package com.iharSm.dataStructures;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class TestHeap {

	@Test
	public void testHeapInsert_Integer_Asc() {
		Heap<Integer> h = new Heap<Integer>(Integer.class, 5, (a, b) -> {
			return Integer.compare(a, b);
		});

		h.insert(10);
		h.insert(12);
		h.insert(9);

		assertTrue(h.heap[0] == 9);
		assertTrue(h.heap[1] == 10);
		assertTrue(h.heap[2] == 12);

	}

	@Test
	public void testHeapInsert_Integer_Dsc() {
		Heap<Integer> h = new Heap<Integer>(Integer.class, 5, (a, b) -> {
			return Integer.compare(b, a);
		});

		h.insert(10);
		h.insert(12);
		h.insert(9);

		assertTrue(h.heap[0] == 12);
		assertTrue(h.heap[1] == 10);
		assertTrue(h.heap[2] == 9);

	}

	@Test
	public void testHeapInsert_String_Asc() {
		Heap<String> h = new Heap<String>(String.class, 5, (a, b) -> {
			return a.compareTo(b);
		});

		h.insert("Google");
		h.insert("Microsoft");
		h.insert("Apple");

		assertTrue(h.heap[0].equals("Apple"));
		assertTrue(h.heap[1].equals("Google"));
		assertTrue(h.heap[2].equals("Microsoft"));

	}

	@Test
	public void testHeapInsert_String_Dsc() {
		Heap<String> h = new Heap<String>(String.class, 5, (a, b) -> {
			return b.compareTo(a);
		});

		h.insert("Google");
		h.insert("Microsoft");
		h.insert("Apple");

		assertTrue(h.heap[2].equals("Apple"));
		assertTrue(h.heap[1].equals("Google"));
		assertTrue(h.heap[0].equals("Microsoft"));

	}

	@Test
	public void testHeapify_Int_Asc() {
		Heap<Integer> h = new Heap<Integer>(Integer.class, 10, (a, b) -> {
			return Integer.compare(a, b);
		});

		h.makeHeap(new Integer[] { Integer.valueOf(1941),
				Integer.valueOf(2001), Integer.valueOf(1918),
				Integer.valueOf(1963), Integer.valueOf(1945),
				Integer.valueOf(1865), Integer.valueOf(1804),
				Integer.valueOf(1776), Integer.valueOf(1783),
				Integer.valueOf(1492) });

		assertTrue(h.heapify().intValue() == 1492);
		
		assertArrayEquals(h.heap, new Integer[] {Integer.valueOf(1776), Integer.valueOf(1804),
				Integer.valueOf(1783), Integer.valueOf(1865),
				Integer.valueOf(1941), Integer.valueOf(1945),
				Integer.valueOf(1963), Integer.valueOf(1918),
				Integer.valueOf(2001), null } );

	}
}
