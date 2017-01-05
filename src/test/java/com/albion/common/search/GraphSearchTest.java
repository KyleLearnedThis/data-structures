package com.albion.common.search;

import com.albion.common.search.graph.BreathFirstSearch;
import com.albion.common.search.graph.DepthFirstSearch;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;

public class GraphSearchTest {

  @Test
  public void testBFS01() {
	  String filePath2 = "src/test/resources/graph01.xml";
	  Graph g = new Graph(filePath2);
	  System.out.println("HEY: "+g.toString());
	  Vertex v = BreathFirstSearch.locate(g, 4);
	  Assert.assertNotNull(v);
	  Assert.assertEquals(v.getId(), 4);
	  Vertex v2 = BreathFirstSearch.locate(g, 5);
	  Assert.assertNull(v2);
  }
  
  @Test
  public void testDFS01() {
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
