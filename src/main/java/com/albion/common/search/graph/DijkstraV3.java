    package com.albion.common.search.graph;

    import com.albion.common.graph.core.v3.Edge;
    import com.albion.common.graph.core.v3.Graph;
    import com.albion.common.graph.core.v3.GraphUtility;
    import com.albion.common.graph.core.v3.Vertex;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class DijkstraV3 {
        private Graph<String> graph;

        public void parseInputIDAsString(String filePath) {
            HashMap<String, Vertex<String>> map = GraphUtility.parseInputIDString(filePath);
            graph.setVerticesMap(map);
        }

        public DijkstraV3(Graph<String> g) {
            this.graph = g;
        }

        public List<Vertex<String>> findShortestDistance(String source, String target) {
            initialize(source);
            List<Vertex<String>> queue = new ArrayList<>();
            for(Map.Entry<String, Vertex<String>> entry : 	graph.getVerticesMap().entrySet()) {
                Vertex<String> v = entry.getValue();
                queue.add(v);
            }

            while(!queue.isEmpty()){
                Vertex<String> u = poll(queue);
                int cost = u.getCost();
                // String uid = u.getId();
                // System.out.println("===== uid: " + uid + " cost: "+ cost);
                List<Edge<String>> edgeList = u.getEdgeList();

                for(Edge<String> edge : edgeList) {
                    String id = edge.getY();
                    int weight = edge.getWeight();
                    int alt = cost + weight;
                    Vertex v = graph.getVertex(id);
                    int neighborWeight = v.getCost();
                    if(alt <  neighborWeight) {
                        v.setCost(alt);
                        v.previous = u;
                    }
                }
            }

            List<Vertex<String>> result = new ArrayList<>();
            Vertex<String> x = graph.getVerticesMap().get(target);
            do{
                result.add(0, x);
                // System.out.println("===== id: " + x.getId() + " cost: " + x.getCost() + " =====");
                x = x.previous;
            } while(x != null);
            return result;
        }

        private Vertex<String> poll(List<Vertex<String>> list) {
            int smallest = Integer.MAX_VALUE;
            for(int i = 0; i < list.size(); i++){
                int curCost = list.get(i).getCost();
                if(smallest > curCost) {
                    smallest = curCost;
                }
            }
            for(int i = 0; i < list.size(); i++) {
                Vertex<String> v = list.get(i);
                if(v.getCost() == smallest){
                    list.remove(i);
                    return v;
                }
            }
            return null;
        }

        private void initialize(String source){
            for(Map.Entry<String, Vertex<String>> entry : graph.getVerticesMap().entrySet()){
                Vertex<String> v = entry.getValue();
                if(v.getId().equals(source)) {
                    v.setCost(0);
                } else {
                    v.setCost(Integer.MAX_VALUE);
                }
                v.previous = null;
            }
        }
    }
