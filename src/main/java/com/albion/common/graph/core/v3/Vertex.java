package com.albion.common.graph.core.v3;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private T id;
    private List<Edge<T>> edgeList;
    private boolean isVisited;
    private int cost;
    public Vertex<T> previous;

    public Vertex(T aId, List<Edge<T>> aList){
        initialize(aId, aList);
    }

    private void initialize(T aid, List<Edge<T>> edgeList){
        this.id = aid;
        isVisited = false;
        cost = 0;
        this.edgeList = edgeList;
    }

    public Vertex(T aId){
        initialize(aId, new ArrayList<>());
    }

    public Vertex(T aId, boolean isRoot){
        initialize(aId, new ArrayList<>());
    }

    public T getId() {
        return id;
    }

    public List<Edge<T>> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge<T>> edgeList) {
        this.edgeList = edgeList;
    }
    public boolean isVisited() {
        return isVisited;
    }
    public void setVisited(boolean traveled) {
        this.isVisited = traveled;
    }

    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("[ID: " + id);
        s.append(" cost: "+ cost+"]\n");
        s.append("\t[EDGES]\n");
        for(Edge edge:edgeList){
            s.append(edge.toString());
        }
        return s.toString();
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
