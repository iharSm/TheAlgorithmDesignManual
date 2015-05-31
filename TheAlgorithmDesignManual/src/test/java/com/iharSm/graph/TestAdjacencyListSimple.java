package com.iharSm.graph;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

public class TestAdjacencyListSimple {

	AdjacencyListSimple list;

	@Before
	public void createAdjacencyList() {
		list = new AdjacencyListSimple();
		
		list.insertEdge(1, 6, false);
		list.insertEdge(1, 2, false);
		list.insertEdge(2, 3, false);
		list.insertEdge(2, 5, false);
		list.insertEdge(1, 5, false);
		list.insertEdge(3, 4, false);
		list.insertEdge(4, 5, false);

		list.setNumberOfVertices(6);
		list.setDirected(false);
	}

	@Test
	public void TestInsertEdge() {
		assertTrue(list.getNumberOfEdges() == 7);
	}
}
