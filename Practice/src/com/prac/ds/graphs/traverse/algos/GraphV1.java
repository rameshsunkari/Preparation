package com.prac.ds.graphs.traverse.algos;

import java.util.List;

public class GraphV1 {
	
	private final List<Vertex> vertexes;
	  private final List<Edge> edges;

	  public GraphV1(List<Vertex> vertexes, List<Edge> edges) {
	    this.vertexes = vertexes;
	    this.edges = edges;
	  }

	  public List<Vertex> getVertexes() {
	    return vertexes;
	  }

	  public List<Edge> getEdges() {
	    return edges;
	  }
	  

}
