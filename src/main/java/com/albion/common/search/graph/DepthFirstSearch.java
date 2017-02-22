package com.albion.common.search.graph;

import com.albion.common.graph.core.v1.Edge;
import com.albion.common.graph.core.v1.Graph;
import com.albion.common.graph.core.v1.Vertex;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
	public static Vertex locate(Graph graph, Integer source, Integer target){

		Stack<Vertex> stack = new Stack<>();
		Vertex root = graph.getVertex(source);
		if(root == null) {
			return null;
		}

		stack.add(root);
		root.setVisited(true);

		while(!stack.isEmpty()) {
			List<Edge> list = stack.pop().getEdgeList();
			for(Edge edge : list) {
				int vertexId = edge.getY();
				Vertex v = graph.getVertex(vertexId);
				if(v == null) {
					throw new RuntimeException("Vertex: " + target + " is not part of graph");
				}
				
				if(vertexId == target) {
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
