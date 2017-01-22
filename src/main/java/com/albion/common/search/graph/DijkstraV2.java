package com.albion.common.search.graph;

import com.albion.common.graph.core.v2.EdgeV2;
import com.albion.common.graph.core.v2.GraphV2;
import com.albion.common.graph.core.v2.VertexV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DijkstraV2 {
    private GraphV2 graph;

    public DijkstraV2(GraphV2 g) {
		this.graph = g;
    }

    public List<VertexV2> findShortestDistance(String source, String target) {
        initializeCost(source);
		List<VertexV2> queue = new ArrayList<>();
		for(Map.Entry<String, VertexV2> entry : 	graph.getVerticesMap().entrySet()) {
			VertexV2 v = entry.getValue();
			queue.add(v);
		}

		while(!queue.isEmpty()){
			VertexV2 u = poll(queue);
			int cost = u.getCost();
			// int uid = u.getId();
			// System.out.println("===== uid: " + uid + " cost: "+ cost);
			List<EdgeV2> edgeList = u.getEdgeList();

			for(EdgeV2 edge : edgeList) {
				String id = edge.getY();
				int weight = edge.getWeight();
				int alt = cost + weight;
				VertexV2 v = graph.getVertex(id);
				int neighborWeight = v.getCost();
				if(alt <  neighborWeight) {
					v.setCost(alt);
					v.previous = u;
				}
			}
		}

		List<VertexV2> result = new ArrayList<>();
		VertexV2 x = graph.getVerticesMap().get(target);
		do{
			result.add(0, x);
			// System.out.println("===== id: " + x.getId() + " cost: " + x.getCost() + " =====");
			x = x.previous;
		} while(x != null);
		return result;
    }

    private VertexV2 poll(List<VertexV2> list) {
    	int smallest = Integer.MAX_VALUE;
    	for(int i = 0; i < list.size(); i++){
    		int curCost = list.get(i).getCost();
    		if(smallest > curCost) {
    			smallest = curCost;
			}
		}
		for(int i = 0; i < list.size(); i++) {
    		VertexV2 v = list.get(i);
    		if(v.getCost() == smallest){
    			list.remove(i);
    			return v;
			}
		}
		return null;
	}

	private void initializeCost(String source){
		for(Map.Entry<String, VertexV2> entry : graph.getVerticesMap().entrySet()){
			VertexV2 v = entry.getValue();
			if(v.getId().equals(source)) {
				v.setCost(0);
			} else {
				v.setCost(Integer.MAX_VALUE);
			}
		}
    }
}
