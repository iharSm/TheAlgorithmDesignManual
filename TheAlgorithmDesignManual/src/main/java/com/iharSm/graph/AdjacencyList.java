package com.iharSm.graph;

/**
 * Class represents a data structure mix between the one designed by Skiena in
 * The Algorithm Design manual and adgecency_list in boost graph library
 */
public class AdjacencyList<T> {

	/* represent the edge-list for each of the vertices */
	private Iterable<T> outEdgeList;
	/* vertex-list of the graph */
	private Iterable<T> vertexList;
	private boolean directed;
	/* number of vertices in the graph */
	private int numberOfVertices;

	/* number of edges in the graph */
	private int numberOfEdges;

	public Iterable<T> getOutEdgeList() {
		return outEdgeList;
	}

	public void setOutEdgeList(Iterable<T> outEdgeList) {
		this.outEdgeList = outEdgeList;
	}

	public Iterable<T> getVertexList() {
		return vertexList;
	}

	public void setVertexList(Iterable<T> vertexList) {
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

	public AdjacencyList(Iterable<T> outEdgeList, Iterable<T> vertexList,
			boolean directed) {
		this.directed = directed;
		this.outEdgeList = outEdgeList;
		this.vertexList = vertexList;
	}
}
