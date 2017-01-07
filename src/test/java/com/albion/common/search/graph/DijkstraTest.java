package com.albion.common.search.graph;

import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class DijkstraTest {
    @Test
    public void testFindShortestPath() throws Exception {
        String filePath2 = "src/test/resources/graph01.xml";
        Graph g = new Graph(filePath2);
        Dijkstra dijkstra = new Dijkstra(g);
        List<Vertex> result = dijkstra.findShortestDistance(1, 4);
        System.out.println("============");
        System.out.println(g.toString());
        for (int i = 0; i < result.size(); i++) {
            Vertex v = result.get(i);
            System.out.println("===== id: " + v.getId() + " cost: " + v.getCost() + " =====");
        }
        Vertex target = result.get(result.size() - 1);
        Assert.assertEquals(target.getCost(), 14);
    }
}