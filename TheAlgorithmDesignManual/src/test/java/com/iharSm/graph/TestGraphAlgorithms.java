package com.iharSm.graph;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;


public class TestGraphAlgorithms {
	AdjacencyListSimple list;
	int count = 0;
		
	@Before
	public void createList(){
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
	public void testBFS(){
		
		//int count = 0; 
		GraphAlgorithms.bfs(list, 1, (s) -> {count++;}, (p, q) -> {return;}, (r) -> {return;});
		assertTrue(count == 6);
		
	}
	
	
}
