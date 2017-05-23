package com.albion.common.graph.core.v2;

import java.util.HashMap;
import java.util.Map;

/*
 * 	private T x; private T y;private W weight;
 * 	private M id; private N data;
 */
public class Graph<T>{
	private HashMap<T, Vertex<T>> verticesMap;

	public Graph() {
        setVerticesMap(new HashMap<>());
    }

    public Graph(HashMap<T, Vertex<T>> map){
		setVerticesMap(map);
	}

	public HashMap<T, Vertex<T>> getVerticesMap() {
		return verticesMap;
	}

	public Vertex<T> getVertex(T id){
		return this.verticesMap.get(id);
	}

	public void setVerticesMap(HashMap<T, Vertex<T>> verticesMap) {
		this.verticesMap = verticesMap;
	}

	public String toString(){
		StringBuffer s = new StringBuffer();
		for(Map.Entry<T, Vertex<T>> entry: verticesMap.entrySet()){
			Vertex<T> v = entry.getValue();
			s.append(v.toString());
		}
		return s.toString();
	}
}
