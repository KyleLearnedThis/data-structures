package com.albion.common.search.graph;

import com.albion.common.graph.core.Edge;
import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;

import java.util.*;

public class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph g) {
		this.graph = g;
    }

    public List<Vertex> findShortestDistance(int source, int target) {
        initializeCost(source);
		List<Vertex> queue = new ArrayList<>();
		for(Map.Entry<Integer, Vertex> entry : 	graph.getVerticesMap().entrySet()) {
			Vertex v = entry.getValue();
			queue.add(v);
		}

		while(!queue.isEmpty()){
			Vertex u = poll(queue);
			int cost = u.getCost();
			// int uid = u.getId();
			// System.out.println("===== uid: " + uid + " cost: "+ cost);
			List<Edge> edgeList = u.getEdgeList();

			for(Edge edge : edgeList) {
				int id = edge.getY();
				int weight = edge.getWeight();
				int alt = cost + weight;
				Vertex v = graph.getVertex(id);
				int neighborWeight = v.getCost();
				if(alt <  neighborWeight) {
					v.setCost(alt);
					v.previous = u;
				}
			}
		}

		List<Vertex> result = new ArrayList<>();
		Vertex x = graph.getVerticesMap().get(target);
		do{
			result.add(0, x);
			// System.out.println("===== id: " + x.getId() + " cost: " + x.getCost() + " =====");
			x = x.previous;
		} while(x != null);
		return result;
    }

    private Vertex poll(List<Vertex> list) {
    	int smallest = Integer.MAX_VALUE;
    	for(int i = 0; i < list.size(); i++){
    		int curCost = list.get(i).getCost();
    		if(smallest > curCost) {
    			smallest = curCost;
			}
		}
		for(int i = 0; i < list.size(); i++) {
    		Vertex v = list.get(i);
    		if(v.getCost() == smallest){
    			list.remove(i);
    			return v;
			}
		}
		return null;
	}

	private void initializeCost(int source){
		for(Map.Entry<Integer, Vertex> entry : graph.getVerticesMap().entrySet()){
			Vertex v = entry.getValue();
			if(v.getId() == source) {
				v.setCost(0);
			} else {
				v.setCost(Integer.MAX_VALUE);
			}
		}
    }
}
