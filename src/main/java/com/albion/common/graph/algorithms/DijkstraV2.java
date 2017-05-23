package com.albion.common.graph.algorithms;

import com.albion.common.graph.core.v2.BaseGraph;
import com.albion.common.graph.core.v2.GraphV2;

public class DijkstraV2 extends BaseDijkstra<String> {

    public DijkstraV2(String filePath){
        super(filePath);
        this.graph = new GraphV2(filePath);
    }

    public DijkstraV2(BaseGraph<String> g) {
        super(g);
    }

    public GraphV2 getGraph(){
        return (GraphV2) this.graph;
    }
}
