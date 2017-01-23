package com.albion.common.search.graph;

import com.albion.common.graph.core.Directions;
import com.albion.common.graph.core.v2.Edge;
import com.albion.common.graph.core.v2.Graph;
import com.albion.common.graph.core.v2.Vertex;
import com.albion.common.utils.XPathTask;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DijkstraV1 extends BaseDijkstra<Integer>{

    public DijkstraV1(Graph<Integer> g) {
        super(g);
    }

    public void parseInput(String filePath) {
        HashMap<Integer, Vertex<Integer>> map = parseInputIDAsInteger(filePath);
        graph.setVerticesMap(map);
    }

    public HashMap<Integer, Vertex<Integer>> parseInputIDAsInteger(String filePath){
        HashMap<Integer, Vertex<Integer>> map = new HashMap<>();
        File inputFile = new File(filePath);

        try {
            XPathTask xpt = new XPathTask(inputFile);
            NodeList vertexList = xpt.processQuery("//vertices/vertex");

            for(int i = 0; i < vertexList.getLength(); i++){
                Node nNode = vertexList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nNode;
                    int vertexId = Integer.parseInt(elem.getAttribute("id"));
                    Vertex<Integer> vertex = new Vertex<>(vertexId);
                    NodeList edgeList = elem.getElementsByTagName("edge");
                    addEdgesToAVertex(vertex, edgeList);
                    map.put(vertexId, vertex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    private Vertex<Integer> addEdgesToAVertex(Vertex<Integer> vertex, NodeList list){
        List<Edge<Integer>> edgeList = new ArrayList<>();
        for(int j = 0; j < list.getLength(); j++){
            Node mNode = list.item(j);
            if (mNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) mNode;
                String id = elem.getAttribute("id");
                String weight = elem.getAttribute("weight");
                String direction = elem.getAttribute("direction");

                Directions way;
                if(!"".equals(direction)){
                    way = Directions.BOTH;
                }else if(direction.equals("A_TO_B")){
                    way = Directions.A_TO_B;
                }else if(direction.equals("B_TO_A")){
                    way = Directions.B_TO_A;
                }else{
                    way = Directions.BOTH;
                }

                if("".equals(weight)){
                    weight = "0";
                }
                Edge<Integer> edge = new Edge<>(vertex.getId(), Integer.parseInt(id), way, Integer.parseInt(weight));
                edgeList.add(edge);
            }
        }
        vertex.setEdgeList(edgeList);
        return vertex;
    }
}
