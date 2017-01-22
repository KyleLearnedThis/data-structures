package com.albion.common.graph.core.v2;


import com.albion.common.graph.core.Directions;

public class EdgeV2 {
	private String x;
	private String y;
	private Directions direction;     // A_TO_B, B_TO_A or BOTH
	private int weight;

	public EdgeV2(String a, String b) {
		setX(a);
		setY(b);
		setDirection(Directions.BOTH);
		weight = -1;
	}

	public EdgeV2(String a, String b, Directions way, int aWeight){
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
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public Directions getDirection() {
		return direction;
	}
	public void setDirection(Directions direction) {
		this.direction = direction;
	}
	public String toString(){
		String s = "\t\t{"+x+","+y+"}  [weight: "+weight+"]-["+direction+"]\n";
		return s;
	}

}
