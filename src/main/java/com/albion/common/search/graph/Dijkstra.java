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

    public List<Integer> findShortestDistance(int source, int target) {
        initializeCost(source);
		final Map<Integer, Integer> distances = new HashMap<>();
		final Map<Integer, Vertex> previous = new HashMap<>();
		List<Vertex> queue = new ArrayList<>();
		for(Map.Entry<Integer, Vertex> entry : 	graph.getVerticesMap().entrySet()) {
			Vertex v = entry.getValue();
			queue.add(v);
		}

		while(!queue.isEmpty()){
			Vertex u = poll(queue);
			int uid = u.getId();
			int cost = u.getCost();
			System.out.println("===== uid: " + uid + " cost: "+ cost);
			List<Edge> edgeList = u.getEdgeList();

			for(Edge edge : edgeList) {
				int id = edge.getY();
				int weight = edge.getWeight();
				int alt = cost + weight;
				Vertex v = graph.getVertex(id);
				int neighborWeight = v.getCost();
				if(alt <  neighborWeight) {
					v.setCost(alt);
					previous.put(id, v);
				}
			}
		}

		List<Integer> result = new ArrayList<>(distances.keySet());
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

	// assumes vertices are numbered 0, 1, ... n and that the source Vertex is 0
	ArrayList<Vertex> findShortestPathV2(Vertex[] vertices, Edge[] edges, Vertex target) {

		int[][] Weight = initializeWeightV2(vertices, edges);
		int[] D = new int[vertices.length];
		Vertex[] P = new Vertex[vertices.length];
		ArrayList<Vertex> C = new ArrayList<>();

		// initialize:
		// (C)andidate set,
		// (D)yjkstra special path length, and
		// (P)revious Vertex along shortest path
		for(int i=0; i<vertices.length; i++){
			C.add(vertices[i]);
			D[i] = Weight[0][i];
			if(D[i] != Integer.MAX_VALUE){
				P[i] = vertices[0];
			}
		}

		// crawl the graph
		for(int i=0; i<vertices.length-1; i++){
			// find the lightest Edge among the candidates
			int l = Integer.MAX_VALUE;
			Vertex n = vertices[0];
			for(Vertex j : C){
				if(D[j.getId()] < l){
					n = j;
					l = D[j.getId()];
				}
			}
			C.remove(n);

			// see if any Edges from this Vertex yield a shorter path than from source->that Vertex
			for(int j=0; j<vertices.length-1; j++){
				if(D[n.getId()] != Integer.MAX_VALUE && Weight[n.getId()][j] != Integer.MAX_VALUE && D[n.getId()]+Weight[n.getId()][j] < D[j]){
					// found one, update the path
					D[j] = D[n.getId()] + Weight[n.getId()][j];
					P[j] = n;
				}
			}
		}
		// we have our path. reuse C as the result list
		C.clear();
		int loc = target.getId();
		C.add(target);
		// backtrack from the target by P(revious), adding to the result list
		while(P[loc] != vertices[0]){
			if(P[loc] == null){
				// looks like there's no path from source to target
				return null;
			}
			C.add(0, P[loc]);
			loc = P[loc].getId();
		}
		C.add(0, vertices[0]);
		return C;
	}

	private int[][] initializeWeightV2(Vertex[] vertices, Edge[] edges){
		int[][] Weight = new int[vertices.length][vertices.length];
		for(int i=0; i<vertices.length; i++){
			Arrays.fill(Weight[i], Integer.MAX_VALUE);
		}
		for(Edge e : edges){
			Weight[e.getX()][e.getY()] = e.getWeight();
		}
		return Weight;
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
