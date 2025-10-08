package cz.vutbr.feec.mpda.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class SCCKosaraju {

	public static List<List<MyVertex>> scc(MyGraph graph) {
		List<List<MyVertex>> result = new ArrayList<>();
		
		// 1) compute start and finish indexes (see dfsRecursive method below)
		orderCounter = 0;
		List<MyVertex> vertices = graph.getVertexList();
		for (MyVertex vertex : vertices) {
			if (!vertex.isUsed()) {
				dfsRecursive(vertex);
			}
		}
		
		// 2) create reverse graph (see T02_ReverseGraphExample)
		MyGraph reversedGraph = reverseGraph(graph);
		
		// reset vertices
		for (MyVertex vertex : reversedGraph.getVertexList()) {
			vertex.setUsed(false);
		}
		
		// 3) sort vertices by finish index (descending), see "sortByFinalIndexDesc" method below
		List<MyVertex> sortedVertices = reversedGraph.getVertexList();
		sortByFinalIndexDesc(sortedVertices);
		
		// 4) find SCC using DFS (see dfsRecursive) and add SCC to result
		for (MyVertex vertex : sortedVertices) {
			if (!vertex.isUsed()) {
				LinkedList<MyVertex> component = dfsRecursive(vertex);
				result.add(component);
			}
		}
		
		return result;
	}
	
    private static void sortByFinalIndexDesc(List<MyVertex> vertexList) {
    	Collections.sort(vertexList, new Comparator<MyVertex>() {
			@Override
			public int compare(MyVertex v1, MyVertex v2) {
				return Integer.compare(v2.getFinish(), v1.getFinish());
			}
		});
	}

	private static MyGraph reverseGraph(MyGraph graph) {
		MyGraph reversedGraph = new MyGraph();
		
		List<MyVertex> vertices = graph.getVertexList();
		for (MyVertex vertex : vertices) {
			for (MyVertex neighbour : vertex.getNeighbours()) {
				reversedGraph.addNode(neighbour.getId(), vertex.getId());
			}
		}
		
		for (MyVertex originalVertex : vertices) {
			MyVertex reversedVertex = reversedGraph.getVertex(originalVertex.getId());
			if (reversedVertex != null) {
				reversedVertex.setStart(originalVertex.getStart());
				reversedVertex.setFinish(originalVertex.getFinish());
			}
		}
		
		return reversedGraph;
	}

	/** 
     * Depth First Search - recursive version
     * 
     * @param vertexList
     * @param whereToStart vertex
     * @return list of reachable nodes
     */
    public static LinkedList<MyVertex> dfsRecursive(MyVertex v){
        LinkedList<MyVertex> result = new LinkedList<>();
        result.add(v);
        v.setUsed(true);
        v.setStart(++orderCounter);
        
        // iterate over all neighbours
        for (int j = 0; j < v.getNeighbours().size(); j++) {
        	MyVertex n = v.getNeighbours().get(j);
        	if(!n.isUsed()) {
        		result.addAll(dfsRecursive(n));
        	}
		}
        v.setFinish(++orderCounter);
        return result;
    }
    
    private static int orderCounter = 0;
}
