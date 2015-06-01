package com.iharSm.graph;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

public class TestGraphAlgorithms {
	AdjacencyListSimple list;
	int count;
	List<String> listOfEdges;
	GraphAlgorithms gAlgo;

	@Before
	public void createList() {
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

		listOfEdges = new ArrayList<String>();
		count = 0;
		gAlgo = new GraphAlgorithms();
	}

	@Test
	public void testBFS_count_vertices() {
		gAlgo.bfs(list, 1, (s) -> {
			count++;
		}, (p, q) -> {
		}, (r) -> {
		});
		assertTrue(count == 6);
	}

	@Test
	public void testBFS() {
		gAlgo.bfs(list, 1, (s) -> {
		}, (p, q) -> listOfEdges.add(p + "->" + q), (r) -> {
		});
		assertTrue(listOfEdges.size() == 7);
	}

	@Test
	public void testBFS_find_the_shortest_path_1_4() {
		assertArrayEquals(gAlgo.findTheShortestPath(list, 1, 4).toArray(new Integer[3]), new Integer[] {1, 5, 4});
	}
	
	@Test
	public void testBFS_find_the_shortest_path_3_6() {
		assertArrayEquals(gAlgo.findTheShortestPath(list, 3, 6).toArray(new Integer[4]), new Integer[] {3, 2, 1, 6});
	}
	
	@Test
	public void testFindNumberOfConnectedComponents_1(){
		assertEquals(gAlgo.findNumberOfConnectedComponents(list), 1);
	}
	
	@Test
	public void testFindNumberOfConnectedComponents_2(){
		list.setNumberOfVertices(8);
		list.insertEdge(7,8, false);
		assertEquals(gAlgo.findNumberOfConnectedComponents(list), 2);
	}
	
	@Test
	public void testDfs_count_vertices(){
		gAlgo.dfs(list, 1, (s) -> {
			count++;
		}, (p, q) -> {
		}, (r) -> {
		});
		
		assertTrue(count == 6);
	}
	
	@Test
	public void testDfs_number_of_edges() {
		gAlgo.dfs(list, 1, (s) -> {
		}, (p, q) -> listOfEdges.add(p + "->" + q), (r) -> {
		});
		assertTrue(listOfEdges.size() == 14);
	}
}
