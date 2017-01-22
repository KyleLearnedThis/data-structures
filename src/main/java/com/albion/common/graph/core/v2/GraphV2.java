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
import java.util.Map;

/*
 * 	private T x; private T y;private W weight;
 * 	private M id; private N data;
 */
public class GraphV2 {
	private HashMap<String, VertexV2> verticesMap;

	public GraphV2(String filePath){
		setVerticesMap(new HashMap<>());
		parseInput(filePath);	
	}

	public void parseInput(String filePath){
		File inputFile = new File(filePath);

		try {
			XPathTask xpt = new XPathTask(inputFile);
			NodeList vertexList = xpt.processQuery("//vertices/vertex");

			for(int i = 0; i < vertexList.getLength(); i++){
				Node nNode = vertexList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String vertexId = elem.getAttribute("id");
					VertexV2 vertex = new VertexV2(vertexId);
					NodeList edgeList = elem.getElementsByTagName("edge");
					addEdgesToAVertex(vertex, edgeList);
					getVerticesMap().put(vertexId, vertex);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VertexV2 addEdgesToAVertex(VertexV2 vertex, NodeList list){
		List<EdgeV2> edgeList = new ArrayList<>();
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
				EdgeV2 edge = new EdgeV2(vertex.getId(), id, way, Integer.parseInt(weight));
				edgeList.add(edge);
			}
		}
		vertex.setEdgeList(edgeList);
		return vertex;
	}

	public HashMap<String, VertexV2> getVerticesMap() {
		return verticesMap;
	}

	public VertexV2 getVertex(String id){
		return this.verticesMap.get(id);
	}

	public void setVerticesMap(HashMap<String, VertexV2> verticesMap) {
		this.verticesMap = verticesMap;
	}

	public String toString(){
		StringBuffer s = new StringBuffer();
		for(Map.Entry<String, VertexV2> entry: verticesMap.entrySet()){
			VertexV2 v = entry.getValue();
			s.append(v.toString());
		}
		return s.toString();
	}
}
