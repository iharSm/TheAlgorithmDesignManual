package com.iharSm.graph;

import java.util.Arrays;
import java.util.LinkedList;

import com.iharSm.graph.AdjacencyListSimple.EdgeNode;

public class GraphAlgorithms {

	enum VertexState {
		DISCOVERED, PROCESSED, UNDISCOVERED
	}

	public static void bfs(AdjacencyListSimple adjList,
			int start, Process processVertexEarly,
			BiProcess processEdge, Process processVertexLate) {

		LinkedList<Integer> queue = new LinkedList<Integer>();
		VertexState[] verticesState = new VertexState[AdjacencyListSimple.maxNubmerOfVertices + 1];
		int[] parentDiscoveryRelationship = new int[AdjacencyListSimple.maxNubmerOfVertices + 1];

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
}