package com.iharSm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

import com.iharSm.graph.AdjacencyListSimple.EdgeNode;

public class GraphAlgorithms {

	private int[] parentDiscoveryRelationship;

	enum VertexState {
		DISCOVERED, PROCESSED, UNDISCOVERED
	}

	public void bfs(AdjacencyListSimple adjList, int start,
			Process processVertexEarly, BiProcess processEdge,
			Process processVertexLate) {

		LinkedList<Integer> queue = new LinkedList<Integer>();
		VertexState[] verticesState = new VertexState[AdjacencyListSimple.maxNubmerOfVertices + 1];
		parentDiscoveryRelationship = new int[AdjacencyListSimple.maxNubmerOfVertices + 1];

		Arrays.fill(verticesState, VertexState.UNDISCOVERED);
		Arrays.fill(parentDiscoveryRelationship, -1);

		int currentVertex;
		int successorVertex;

		EdgeNode node;

		queue.addFirst(start);
		verticesState[start] = VertexState.DISCOVERED;

		while (!queue.isEmpty()) {
			currentVertex = queue.poll();
			processVertexEarly.accept(currentVertex);
			verticesState[currentVertex] = VertexState.PROCESSED;
			node = adjList.getEdges()[currentVertex];
			while (node != null) {
				successorVertex = node.adjacencyInfo;
				if (verticesState[successorVertex] != VertexState.PROCESSED
						|| adjList.isDirected() == true) {
					processEdge.accept(currentVertex, successorVertex);
				}
				if (verticesState[successorVertex] == VertexState.UNDISCOVERED) {
					queue.add(successorVertex);
					verticesState[successorVertex] = VertexState.DISCOVERED;
					parentDiscoveryRelationship[successorVertex] = currentVertex;
				}
				node = node.nextEdge;
			}
			processVertexLate.accept(currentVertex);
		}
	}

	public List<Integer> findTheShortestPath(AdjacencyListSimple adjList,
			int from, int to) {
		List<Integer> path = new ArrayList<Integer>();
		this.bfs(adjList, from, (p) -> {
		}, (q, r) -> {
		}, (s) -> {
		});

		findPath(path, from, to);
		path.add(to);
		return path;
	}

	private void findPath(List<Integer> path, int from, int to){
		
		if(from == this.getParent(to)){
			path.add(from);
		} else {
			findPath(path, from, this.getParent(to));
			path.add(this.getParent(to));
		}
		
	}

	public int getParent(int child) {
		return this.parentDiscoveryRelationship[child];
	}
}