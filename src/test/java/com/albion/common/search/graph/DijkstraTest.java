package com.albion.common.search.graph;

import com.albion.common.graph.core.Graph;
import com.albion.common.graph.core.Vertex;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class DijkstraTest {
    @Test
    public void testFindShortestPathV1() throws Exception {
        String filePath2 = "src/test/resources/graph01.xml";
        Graph g = new Graph(filePath2);
        HashMap<Integer, Vertex> x = g.getVerticesMap();
        Random random = new Random();
        PriorityQueue<Vertex> queue = new PriorityQueue<>((v1, v2)->(v1.getCost() - v2.getCost()));

        Set<Map.Entry<Integer, Vertex>> w = x.entrySet();

        for(Map.Entry<Integer, Vertex> entry: w) {
            int cost = random.nextInt() % 100;
            cost = Math.abs(cost);
            int id = entry.getKey();
            Vertex v = entry.getValue();
            System.out.println("SET COST ---- ID: " + id + " cost: " + cost);
            v.setCost(cost);
            queue.add(v);
        }

        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            System.out.println("ID: " + v.getId() + " cost: " + v.getCost());
        }
    }
    @Test
    public void testFindShortestPathV2() throws Exception {
        String filePath2 = "src/test/resources/graph01.xml";
        Graph g = new Graph(filePath2);
        System.out.println(g.toString());
        Dijkstra dijkstra = new Dijkstra(g);
        List<Integer> result = dijkstra.findShortestDistance(1, 4);
        System.out.println("============");
        System.out.println(g.toString());
        Assert.assertNotNull(result);
    }
}