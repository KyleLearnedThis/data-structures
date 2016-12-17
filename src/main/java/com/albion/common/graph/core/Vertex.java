package com.albion.common.graph.core;

import java.util.List;

public class Vertex {

	final private int id;
	private List<Edge> edgeList;
	private boolean isVisited;
	
	private int cost; 
	
	public Vertex(int aId, List<Edge> aList){
		id = aId;
		setEdgeList(aList);
		isVisited = false;
		cost = Integer.MAX_VALUE;
	}
	
	public Vertex(int aId){
		id = aId;
		isVisited = false;
		cost = Integer.MAX_VALUE;
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
	public boolean isVisted() {
		return isVisited;
	}
	public void setVisted(boolean traveled) {
		this.isVisited = traveled;
	}
	//hello
	public String toString(){
		StringBuffer s = new StringBuffer();
		s.append("[Vertex ID]-["+id+"]\n");
		s.append("[EDGES]\n");
		for(Edge edge:edgeList){
			s.append(edge.toString());
		}
		return s.toString();
	}
}
