package com.albion.common.graph.algorithms;

import com.albion.common.graph.core.v2.GraphV1;

public class DijkstraV1 extends BaseDijkstra<Integer>{
    public DijkstraV1() {

    }

    public DijkstraV1(String filePath){
        super(filePath);
        this.graph = new GraphV1(filePath);
    }

    public DijkstraV1(GraphV1 g) {
        super(g);
    }

    public GraphV1 getGraph() {
        return (GraphV1) this.graph;
    }
}
