package com.albion.common.graph.core.v1;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int id;
	private List<Edge> edgeList;
	private boolean isVisited;
	private int cost;
	public Vertex previous;

	public Vertex(int aId, List<Edge> aList){
		initialize(aId, aList);
	}

	private void initialize(int aid, List<Edge> edgeList){
		this.id = aid;
		isVisited = false;
		cost = 0;
		this.edgeList = edgeList;
	}

	public Vertex(int aId){
		initialize(aId, new ArrayList<>());
	}

	public Vertex(int aId, boolean isRoot){
		initialize(aId, new ArrayList<>());
	}

	public int getId() {
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
