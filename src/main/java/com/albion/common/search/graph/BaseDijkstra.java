package com.albion.common.search.graph;

import com.albion.common.graph.core.v2.Edge;
import com.albion.common.graph.core.v2.Graph;
import com.albion.common.graph.core.v2.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract public class BaseDijkstra<T> {
    protected Graph<T> graph;

    public BaseDijkstra(Graph<T> g) {
        this.graph = g;
    }

    public List<Vertex<T>> findShortestDistance(T source, T target) {
        initialize(source);
        List<Vertex<T>> queue = new ArrayList<>();
        for(Map.Entry<T, Vertex<T>> entry : graph.getVerticesMap().entrySet()) {
            Vertex<T> v = entry.getValue();
            queue.add(v);
        }

        while(!queue.isEmpty()){
            Vertex<T> u = poll(queue);
            int cost = u.getCost();
            // T uid = u.getId();
            // System.out.println("===== uid: " + uid + " cost: "+ cost);
            List<Edge<T>> edgeList = u.getEdgeList();

            for(Edge<T> edge : edgeList) {
                T id = edge.getY();
                int weight = edge.getWeight();
                int alt = cost + weight;
                Vertex<T> v = graph.getVertex(id);
                int neighborWeight = v.getCost();
                if(alt <  neighborWeight) {
                    v.setCost(alt);
                    v.previous = u;
                }
            }
        }

        List<Vertex<T>> result = new ArrayList<>();
        Vertex<T> x = graph.getVerticesMap().get(target);
        do{
            result.add(0, x);
            // System.out.println("===== id: " + x.getId() + " cost: " + x.getCost() + " =====");
            x = x.previous;
        } while(x != null);
        return result;
    }

    private Vertex<T> poll(List<Vertex<T>> list) {
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++){
            int curCost = list.get(i).getCost();
            if(smallest > curCost) {
                smallest = curCost;
            }
        }
        for(int i = 0; i < list.size(); i++) {
            Vertex<T> v = list.get(i);
            if(v.getCost() == smallest){
                list.remove(i);
                return v;
            }
        }
        return null;
    }

    private void initialize(T source){
        for(Map.Entry<T, Vertex<T>> entry : graph.getVerticesMap().entrySet()){
            Vertex<T> v = entry.getValue();
            if(v.getId().equals(source)) {
                v.setCost(0);
            } else {
                v.setCost(Integer.MAX_VALUE);
            }
            v.previous = null;
        }
    }
}
