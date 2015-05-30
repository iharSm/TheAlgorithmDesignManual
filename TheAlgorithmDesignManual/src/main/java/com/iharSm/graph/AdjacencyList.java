package com.iharSm.graph;

/**
 * Class represents a data structure mix between the one designed by Skiena in
 * The Algorithm Design manual and adgecency_list in boost graph library
 */
public class AdjacencyList<T extends Iterable<?>, S extends Iterable<?>> {

	/* represent the edge-list for each of the vertices */
	private T outEdgeList;
	/* vertex-list of the graph */
	private S vertexList;
	private boolean directed;
	/* number of vertices in the graph */
	private int numberOfVertices;

	/* number of edges in the graph */
	private int numberOfEdges;

	public T getOutEdgeList() {
		return outEdgeList;
	}

	public void setOutEdgeList(T outEdgeList) {
		this.outEdgeList = outEdgeList;
	}

	public S getVertexList() {
		return vertexList;
	}

	public void setVertexList(S vertexList) {
		this.vertexList = vertexList;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	public void setNumberOfEdges(int numberOfEdges) {
		this.numberOfEdges = numberOfEdges;
	}
}
