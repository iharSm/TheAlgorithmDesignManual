package com.iharSm.graph;

public class AdjacencyListSimple {

	public static int maxNubmerOfVertices = 1000;
	private EdgeNode[] edges = new EdgeNode[maxNubmerOfVertices + 1];
	private int[] outDegreeVertex = new int[maxNubmerOfVertices + 1];
	private boolean directed;
	/* number of vertices in the graph */
	private int numberOfVertices;

	/* number of edges in the graph */
	private int numberOfEdges;

	
	public AdjacencyListSimple(boolean directed){
		
	}
	
	public AdjacencyListSimple(){
		this(false);
	}
	
	public void insertEdge(EdgeNode node){
		node.nextEdge = this.edges[node.adjacencyInfo];
		this.edges[node.adjacencyInfo] = node;
		this.outDegreeVertex[node.adjacencyInfo] ++;
		numberOfVertices++;
	}
	
	
	public class EdgeNode {
		public int adjacencyInfo;
		public int edgeWeight;
		public EdgeNode nextEdge;
	}

	public EdgeNode[] getEdges() {
		return edges;
	}

	public void setEdges(EdgeNode[] edges) {
		this.edges = edges;
	}

	public int[] getOutDegreeVertex() {
		return outDegreeVertex;
	}

	public void setOutDegreeVertex(int[] outDegreeVertex) {
		this.outDegreeVertex = outDegreeVertex;
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