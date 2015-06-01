package com.iharSm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

import com.iharSm.graph.AdjacencyListSimple.EdgeNode;

public class GraphAlgorithms {

	private int[] enterTime = new int[AdjacencyListSimple.maxNumberOfVertices];
	private int[] exitTime = new int[AdjacencyListSimple.maxNumberOfVertices];
	private int[] parentDiscoveryRelationship = new int[AdjacencyListSimple.maxNumberOfVertices + 1];
	private VertexState[] verticesState = new VertexState[AdjacencyListSimple.maxNumberOfVertices + 1];
	private int time;

	enum VertexState {
		DISCOVERED, PROCESSED, UNDISCOVERED
	}

	public void dfs(AdjacencyListSimple adjList, int start) {
		this.dfs(adjList, start, p -> {
		}, (p, q) -> {
		}, p -> {
		});
	}

	public void bfs(AdjacencyListSimple adjList, int start) {
		this.bfs(adjList, start, p -> {
		}, (p, q) -> {
		}, p -> {
		});
	}

	public void dfs(AdjacencyListSimple adjList, int start,
			Process processVertexEarly, BiProcess processVertex,
			Process processVertexLate) {
		Arrays.fill(verticesState, VertexState.UNDISCOVERED);
		Arrays.fill(parentDiscoveryRelationship, -1);
		time = 0;

		recurcivedfs(adjList, start, processVertexEarly, processVertex,
				processVertexLate);
	}

	private void recurcivedfs(AdjacencyListSimple adjList, int start,
			Process processVertexEarly, BiProcess processVertex,
			Process processVertexLate) {

		verticesState[start] = VertexState.DISCOVERED;
		int c = start;
		enterTime[c] = time++;
		processVertexEarly.accept(c);

		EdgeNode current = adjList.getEdges()[c];
		while (current != null) {
			int v = current.adjacencyInfo;

			if (verticesState[v] == VertexState.UNDISCOVERED) {
				parentDiscoveryRelationship[v] = c;
				processVertex.accept(c, v);
				recurcivedfs(adjList, v, processVertexEarly, processVertex,
						processVertexLate);
			} else if (verticesState[v] != VertexState.UNDISCOVERED
					|| adjList.isDirected()) {
				processVertex.accept(c, v);
			}

			current = current.nextEdge;
		}
		exitTime[c] = time++;
		processVertexLate.accept(c);
		verticesState[c] = VertexState.PROCESSED;
	}

	public void bfs(AdjacencyListSimple adjList, int start,
			Process processVertexEarly, BiProcess processEdge,
			Process processVertexLate) {

		LinkedList<Integer> queue = new LinkedList<Integer>();

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
		this.bfs(adjList, from);

		findPath(path, from, to);
		path.add(to);
		return path;
	}

	private void findPath(List<Integer> path, int from, int to) {

		if (from == this.getParent(to)) {
			path.add(from);
		} else {
			findPath(path, from, this.getParent(to));
			path.add(this.getParent(to));
		}

	}

	public int findNumberOfConnectedComponents(AdjacencyListSimple adjList) {
		int counter = 1;

		this.bfs(adjList, 1);
		for (int i = 1; i < adjList.getNumberOfVertices(); i++) {
			if (this.verticesState[i] == VertexState.UNDISCOVERED) {
				this.bfs(adjList, i);
				counter++;
			}
		}

		return counter;
	}

	public int getParent(int child) {
		return this.parentDiscoveryRelationship[child];
	}
}