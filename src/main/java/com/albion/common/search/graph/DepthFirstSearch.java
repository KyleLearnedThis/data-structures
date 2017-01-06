package com.albion.common.search.graph;

import com.albion.common.graph.core.Edge;
import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
	public static Vertex locate(Graph graph, Integer id){
		Stack<Vertex> stack = new Stack<Vertex>();
		graph.getVertex(0);
		Vertex root = graph.getRoot();

		stack.add(root);
		root.setVisited(true);

		while(!stack.isEmpty()) {			
			List<Edge> list = stack.pop().getEdgeList();
			for(Edge edge : list) {
				int vertexId = edge.getY();
				Vertex v = graph.getVertex(vertexId);
				if(v == null) {
					throw new RuntimeException("Vertex: " + id + " is not part of graph");
				}
				
				if(vertexId == id) {
					return v;
				}

				if(!v.isVisited()) {
					stack.add(v);
					v.setVisited(true);
				}
			}
		}
		return null;
	}
}
