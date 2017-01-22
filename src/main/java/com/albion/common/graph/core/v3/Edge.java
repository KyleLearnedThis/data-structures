package com.albion.common.graph.core.v3;


import com.albion.common.graph.core.Directions;

public class Edge<T> {
	T x;
	T y;
	private Directions direction;     // A_TO_B, B_TO_A or BOTH
	private int weight;

	public Edge(T a, T b) {
		setX(a);
		setY(b);
		setDirection(Directions.BOTH);
		weight = -1;
	}

	public Edge(T a, T b, Directions way, int aWeight){
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
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	public Directions getDirection() {
		return direction;
	}
	public void setDirection(Directions direction) {
		this.direction = direction;
	}
	public String toString(){
		String s = "\t\t{"+x+", "+y+"}  [weight: "+weight+"]-["+direction+"]\n";
		return s;
	}

}
