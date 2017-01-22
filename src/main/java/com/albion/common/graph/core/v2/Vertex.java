package com.albion.common.graph.core.v2;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String id;
    private List<Edge> edgeList;
    private boolean isVisited;
    private int cost;
    public Vertex previous;

    public Vertex(String aId, List<Edge> aList){
        initialize(aId, aList);
    }

    private void initialize(String aid, List<Edge> edgeList){
        this.id = aid;
        isVisited = false;
        cost = 0;
        this.edgeList = edgeList;
    }

    public Vertex(String aId){
        initialize(aId, new ArrayList<>());
    }

    public Vertex(String aId, boolean isRoot){
        initialize(aId, new ArrayList<>());
    }

    public String getId() {
        return id;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
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
