package com.albion.common.graph.core.v3;

import java.util.HashMap;
import java.util.Map;

/*
 * 	private T x; private T y;private W weight;
 * 	private M id; private N data;
 */
public class Graph<T>{
	private HashMap<String, Vertex<T>> verticesMap;

	public Graph() {
        setVerticesMap(new HashMap<>());
    }

	public HashMap<String, Vertex<T>> getVerticesMap() {
		return verticesMap;
	}

	public Vertex<T> getVertex(T id){
		return this.verticesMap.get(id);
	}

	public void setVerticesMap(HashMap<String, Vertex<T>> verticesMap) {
		this.verticesMap = verticesMap;
	}

	public String toString(){
		StringBuffer s = new StringBuffer();
		for(Map.Entry<String, Vertex<T>> entry: verticesMap.entrySet()){
			Vertex<T> v = entry.getValue();
			s.append(v.toString());
		}
		return s.toString();
	}
}
