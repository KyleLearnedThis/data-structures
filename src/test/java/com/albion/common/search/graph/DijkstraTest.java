package com.albion.common.search.graph;

import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class DijkstraTest {
    @DataProvider(name = "dp01")
    public Object[][] makeData() {
        return new Object[][] {
                {"src/test/resources/graph01.xml", 1, 4, 14},
                {"src/test/resources/graph02.xml", 1, 5, 13}
        };
    }
    @Test(dataProvider = "dp01")
    public void testFindShortestPath(String filePath, int src, int destination, int expectedCost) throws Exception {
        Graph g = new Graph(filePath);
        Dijkstra dijkstra = new Dijkstra(g);
        List<Vertex> result = dijkstra.findShortestDistance(src, destination);
        System.out.println("============");
        System.out.println(g.toString());

        System.out.println("[Shortest Path]");
        int size = result.size();
        for (int i = 0; i < size; i++) {
            Vertex v = result.get(i);
            System.out.print("[ID:" + v.getId() + " cost:" + v.getCost() + "]");
            if(i != size - 1) {
                System.out.print("-->");
            }
        }
        System.out.println("");
        Vertex target = result.get(result.size() - 1);
        Assert.assertEquals(target.getCost(), expectedCost);
    }

}