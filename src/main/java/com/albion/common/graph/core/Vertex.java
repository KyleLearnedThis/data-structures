package com.albion.common.graph.core;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int id;
	private List<Edge> edgeList;
	private boolean isVisited;
	private int cost; 
	private boolean isRoot;

	public Vertex(int aId, List<Edge> aList){
		initialize(aId, aList, false);
	}

	private void initialize(int aid, List<Edge> edgeList, boolean isRoot){
		this.id = aid;
		isVisited = false;
		cost = 0;
		this.isRoot = isRoot;
		this.edgeList = edgeList;
	}

	public Vertex(int aId){
		initialize(aId, new ArrayList<>(), false);
	}

	public Vertex(int aId, boolean isRoot){
		initialize(aId, new ArrayList<>(), isRoot);
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
		if(isRoot == true) {
			s.append("[*ROOT ID: " + id);
		} else {
			s.append("[ID: " + id);
		}

		s.append(" cost: "+ cost+"]\n");
		s.append("\t[EDGES]\n");
		for(Edge edge:edgeList){
			s.append(edge.toString());
		}
		return s.toString();
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean root) {
		isRoot = root;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
