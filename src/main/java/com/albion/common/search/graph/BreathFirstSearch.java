package com.albion.common.search.graph;

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
			Vertex v = queue.get(0);
			queue.remove(0);
			
			if(v.getId() == target.intValue()){
				v.setVisited(true);
				return v;
			}
			
			List<Edge> edgeList = v.getEdgeList();
			for(Edge edge:edgeList){
				Vertex y = graph.getVerticesMap().get(edge.getY());
				if(y.isVisited() == false){
					y.setVisited(true);
					queue.add(y);
				}
			}
		}

		return null;
	}

}
