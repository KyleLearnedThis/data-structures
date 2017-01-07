package com.albion.common.search.graph;

import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DepthFirstSearchTest {
    @Test
    public void testLocate() throws Exception {
        String filePath2 = "src/test/resources/graph01.xml";
        Graph g = new Graph(filePath2);
        System.out.println("HEY: "+g.toString());
        Vertex v = DepthFirstSearch.locate(g, 4);
        Assert.assertNotNull(v);
        Assert.assertEquals(v.getId(), 4);
        Vertex v2 = BreathFirstSearch.locate(g, 5);
        Assert.assertNull(v2);
    }

}