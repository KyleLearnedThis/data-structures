package com.albion.common.graph.algorithms;

import com.albion.common.graph.core.v1.Edge;
import com.albion.common.graph.core.v1.Graph;
import com.albion.common.graph.core.v1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class BreathFirstSearch {

	public static Vertex locate(Graph graph, Integer source, Integer target){
		List<Vertex> queue = new ArrayList<>();
		Vertex root = graph.getVertex(source);
		queue.add(root);
		
		while(!queue.isEmpty()){
			Vertex v = queue.remove(0);
			
			if(v.getId() == target.intValue()){
				v.setVisited(true);
				return v;
			}
			
			List<Edge> edgeList = v.getEdgeList();
			for(Edge edge : edgeList){
				int vertexId = edge.getY();
				Vertex w = graph.getVerticesMap().get(vertexId);
				if(w.isVisited() == false){
					w.setVisited(true);
					queue.add(w);
				}
			}
		}

		return null;
	}

}
