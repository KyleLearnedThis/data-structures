package com.albion.common.graph.core.v2;

import java.util.ArrayList;
import java.util.List;

public class VertexV2 {

    private String id;
    private List<EdgeV2> edgeList;
    private boolean isVisited;
    private int cost;
    public VertexV2 previous;

    public VertexV2(String aId, List<EdgeV2> aList){
        initialize(aId, aList);
    }

    private void initialize(String aid, List<EdgeV2> edgeList){
        this.id = aid;
        isVisited = false;
        cost = 0;
        this.edgeList = edgeList;
    }

    public VertexV2(String aId){
        initialize(aId, new ArrayList<>());
    }

    public VertexV2(String aId, boolean isRoot){
        initialize(aId, new ArrayList<>());
    }

    public String getId() {
        return id;
    }

    public List<EdgeV2> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<EdgeV2> edgeList) {
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
        for(EdgeV2 edge:edgeList){
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
