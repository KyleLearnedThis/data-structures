package com.albion.common.search.graph;

import com.albion.common.graph.core.v3.Graph;
import com.albion.common.graph.core.v3.Vertex;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DijkstraV3Test {
    @DataProvider(name = "dp01")
    public Object[][] makeData() {
        return new Object[][] {
                {"src/test/resources/graph03.xml", "San Francisco", "Boston", 14},
                {"src/test/resources/graph04.xml", "San Francisco", "Chicago", 13}
        };
    }

    @Test(dataProvider = "dp01")
    public void testFindShortestPath(String filePath, String src, String destination, int expectedCost) throws Exception {
        Graph<String> g = new Graph<>();
        DijkstraV3 dijkstra = new DijkstraV3(g);
        dijkstra.parseInputIDAsString(filePath);

        List<Vertex<String>> result = dijkstra.findShortestDistance(src, destination);
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