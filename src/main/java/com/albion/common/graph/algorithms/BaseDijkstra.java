package com.albion.common.graph.algorithms;

import com.albion.common.graph.core.v2.Edge;
import com.albion.common.graph.core.v2.BaseGraph;
import com.albion.common.graph.core.v2.Vertex;

import java.util.*;

abstract public class BaseDijkstra<T> {
    protected BaseGraph<T> graph;
    String filePath;

    public BaseDijkstra(BaseGraph<T> g) {
        this.graph = g;
    }
    public BaseDijkstra(String filePath) {
        this.filePath = filePath;
    }

    public List<Vertex<T>> findShortestDistance(T source, T target) {
        initialize(source);
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>((o1, o2)->(o1.getCost() - o2.getCost()));
        for(Map.Entry<T, Vertex<T>> entry : graph.getVerticesMap().entrySet()) {
            Vertex<T> v = entry.getValue();
            queue.add(v);
        }

        while(!queue.isEmpty()){
            Vertex<T> u = queue.poll();
            int cost = u.getCost();
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
                    refreshQueue(queue, v);
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

    private void refreshQueue(PriorityQueue<Vertex<T>> queue, Vertex<T> vertex) {
        Vertex<T> removeVertex = null;
        Iterator<Vertex<T>> iterator = queue.iterator();
        while(iterator.hasNext()){
            Vertex<T> v = iterator.next();
            if(vertex.getId() == v.getId()){
                removeVertex = v;
                break;
            }
        }
        if(removeVertex != null) {
            queue.remove(removeVertex);
            queue.add(removeVertex);
        }
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
