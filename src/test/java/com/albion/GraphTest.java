package com.albion.common.test;

import org.testng.annotations.Test;

import com.albion.common.graph.core.Graph;

public class GraphTest {

  @Test
  public void testGraph01() {
	  String filePath2 = "src/main/java/com/albion/common/data/graph01.xml";	  
	  Graph g = new Graph(filePath2);
	  System.out.println("HEY: "+g.toString());
  }
  
}
