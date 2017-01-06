package com.albion.common.search.graph;

import com.albion.common.graph.core.Edge;
import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;

import java.util.ArrayList;
import java.util.List;

public class BreathFirstSearch {

	public static Vertex locate(Graph graph, Integer id){
		List<Vertex> queue = new ArrayList<Vertex>();
		Vertex root = graph.getRoot();
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			Vertex v = queue.get(0);
			queue.remove(0);
			
			if(v.getId() == id.intValue()){
				v.setVisited(true);
				return v;
			}
			
			List<Edge> edgeList = v.getEdgeList();
			for(Edge edge:edgeList){
				Vertex x = graph.getVerticesMap().get(edge.getX());
				Vertex y = graph.getVerticesMap().get(edge.getY());
				if(x.isVisited() == false){
					x.setVisited(true);
					queue.add(x);
				}
				if(y.isVisited() == false){
					y.setVisited(true);
					queue.add(y);
				}
			}
		}

		return null;
	}

}
