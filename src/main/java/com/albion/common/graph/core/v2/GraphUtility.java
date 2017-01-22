package com.albion.common.graph.core.v2;

import com.albion.common.graph.core.Directions;
import com.albion.common.utils.XPathTask;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphUtility {

    public static HashMap<String, Vertex<String>> parseInputIDString(String filePath){
        HashMap<String, Vertex<String>> map = new HashMap<>();
		File inputFile = new File(filePath);

		try {
			XPathTask xpt = new XPathTask(inputFile);
			NodeList vertexList = xpt.processQuery("//vertices/vertex");

			for(int i = 0; i < vertexList.getLength(); i++){
				Node nNode = vertexList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String vertexId = elem.getAttribute("id");
					Vertex<String> vertex = new Vertex<>(vertexId);
					NodeList edgeList = elem.getElementsByTagName("edge");
					addEdgesToAVertexV2(vertex, edgeList);
					map.put(vertexId, vertex);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	private static Vertex<String> addEdgesToAVertexV2(Vertex<String> vertex, NodeList list){
		List<Edge<String>> edgeList = new ArrayList<>();
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
				Edge<String> edge = new Edge<>(vertex.getId(), id, way, Integer.parseInt(weight));
				edgeList.add(edge);
			}
		}
		vertex.setEdgeList(edgeList);
		return vertex;
	}

    public static HashMap<Integer, Vertex<Integer>> parseInputIDInteger(String filePath){
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
                    addEdgesToAVertexV1(vertex, edgeList);
                    map.put(vertexId, vertex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    private static Vertex<Integer> addEdgesToAVertexV1(Vertex<Integer> vertex, NodeList list){
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
