package cz.vutbr.feec.mpda.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class SCCKosaraju {

	public static List<List<MyVertex>> scc(MyGraph graph) {
		List<List<MyVertex>> result = new ArrayList<>();
		// 1) compute start and finish indexes (see dfsRecursive method below). 
		// 2) create reverse graph (see T02_ReverseGraphExample)
		// 3) sort vertices by finish index (descending), see "sortByFinalIndexDesc" method below
		// 4) find SCC using DFS (see dfsRecursive) and add SCC to result
		return result;
	}
	
    private static void sortByFinalIndexDesc(List<MyVertex> vertexList) {
    	//TODO

	}

	private static MyGraph reverseGraph(MyGraph graph) {
		// TODO
		return null;
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
