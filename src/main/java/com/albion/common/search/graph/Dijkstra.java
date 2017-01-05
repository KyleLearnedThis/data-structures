package com.albion.common.search.graph;

import com.albion.common.graph.core.Edge;
import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    Graph graph = null;

    public Dijkstra(Graph g) {
        this.graph = g;
    }

    public ArrayList<Edge> findShortestDistance(Integer targetId) {
        initializeWeight();

        return null;
//        Vertex[] vertices = g.getVertexArray();
//        int[][] Weight = initializeWeight(vertices, edges);
//        int[] D = new int[vertices.length];
//        Vertex[] P = new Vertex[vertices.length];
//        ArrayList<Vertex> C = new ArrayList<>();
//
//        // initialize:
//        // (C)andidate set,
//        // (D)yjkstra special path length, and
//        // (P)revious Vertex along shortest path
//        for(int i=0; i<vertices.length; i++){
//            C.add(vertices[i]);
//            D[i] = Weight[0][i];
//            if(D[i] != Integer.MAX_VALUE){
//                P[i] = vertices[0];
//            }
//        }
//
//        // crawl the graph
//        for(int i=0; i<vertices.length-1; i++){
//            // find the lightest Edge among the candidates
//            int l = Integer.MAX_VALUE;
//            Vertex n = vertices[0];
//            for(Vertex j : C){
//                if(D[j.getId()] < l){
//                    n = j;
//                    l = D[j.getId()];
//                }
//            }
//            C.remove(n);
//
//            // see if any Edges from this Vertex yield a shorter path than from source->that Vertex
//            for(int j=0; j<vertices.length-1; j++){
//                if(D[n.getId()] != Integer.MAX_VALUE && Weight[n.getId()][j] != Integer.MAX_VALUE && D[n.getId()]+Weight[n.getId()][j] < D[j]){
//                    // found one, update the path
//                    D[j] = D[n.getId()] + Weight[n.getId()][j];
//                    P[j] = n;
//                }
//            }
//        }
//        // we have our path. reuse C as the result list
//        C.clear();
//        int loc = targetId;
//        Vertex n = g.getVertex(targetId);
//        C.add(n);
//        // backtrack from the target by P(revious), adding to the result list
//        while(P[loc] != vertices[0]){
//            if(P[loc] == null){
//                // looks like there's no path from source to target
//                return null;
//            }
//            C.add(0, P[loc]);
//            loc = P[loc].getId();
//        }
//        C.add(0, vertices[0]);
//        return C;
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

    private void initializeWeight(){
	    for(Map.Entry<Integer, Vertex> entry : graph.getGraph().entrySet()){
	        Vertex v = entry.getValue();
	        List<Edge> edgeList = v.getEdgeList();
            for(Edge edge : edgeList) {
                edge.setWeight(Integer.MAX_VALUE);
            }
        }
    }
}
