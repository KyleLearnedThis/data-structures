package com.albion.common.graph.core;



public class Edge {

	private int x;
	private int y;
	private Directions direction;     // A_TO_B, B_TO_A or BOTH
	private int weight;

	public Edge(int a, int b) {
		setX(a);
		setY(b);
		setDirection(Directions.BOTH);
		weight = -1;
	}

	public Edge(int a, int b, Directions way, int aWeight){
		setX(a);
		setY(b);
		setDirection(way);
		setWeight(aWeight);
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Directions getDirection() {
		return direction;
	}
	public void setDirection(Directions direction) {
		this.direction = direction;
	}
	public String toString(){
		StringBuffer s = new StringBuffer();
		s.append("("+x+","+y+")-[weight]-["+weight+"]-[direction]-["+direction+"]\n");		
		return s.toString();
	}

}
