package com.albion.common.graph.algorithms;

import com.albion.common.graph.algorithms.BreathFirstSearch;
import com.albion.common.graph.core.v1.Graph;
import com.albion.common.graph.core.v1.Vertex;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BreathFirstSearchTest {
    @Test
    public void testLocate() throws Exception {
        String filePath2 = "src/test/resources/graph01.xml";
        Graph g = new Graph(filePath2);
        System.out.println(g.toString());
        Vertex v = BreathFirstSearch.locate(g, 1, 4);
        Assert.assertNotNull(v);
        Assert.assertEquals(v.getId(), 4);
        Vertex v2 = BreathFirstSearch.locate(g, 1, 5);
        Assert.assertNull(v2);
    }
}