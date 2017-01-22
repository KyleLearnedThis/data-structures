package com.albion.common.search.graph;

import com.albion.common.graph.core.v2.GraphV2;
import com.albion.common.graph.core.v2.VertexV2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DijkstraV2Test {
    @DataProvider(name = "dp01")
    public Object[][] makeData() {
        return new Object[][] {
                {"src/test/resources/graph03.xml", "San Francisco", "Boston", 14}
//                ,
//                {"src/test/resources/graph04.xml", 'San Francisco", "Chicago", 13}
        };
    }
    @Test(dataProvider = "dp01")
    public void testFindShortestPath(String filePath, String src, String destination, int expectedCost) throws Exception {
        GraphV2 g = new GraphV2(filePath);
        DijkstraV2 dijkstra = new DijkstraV2(g);
        List<VertexV2> result = dijkstra.findShortestDistance(src, destination);
        System.out.println("============");
        System.out.println(g.toString());

        System.out.println("[Shortest Path]");
        int size = result.size();
        for (int i = 0; i < size; i++) {
            VertexV2 v = result.get(i);
            System.out.print("[ID:" + v.getId() + " cost:" + v.getCost() + "]");
            if(i != size - 1) {
                System.out.print("-->");
            }
        }
        System.out.println("");
        VertexV2 target = result.get(result.size() - 1);
        Assert.assertEquals(target.getCost(), expectedCost);
    }

}