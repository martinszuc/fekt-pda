package cz.vutbr.feec.mpda.examples;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * This class demonstrates some of the operations that can be performed on
 * directed graphs. After constructing a basic directed graph, it computes all
 * the strongly connected components of this graph. It then finds the shortest
 * path from one vertex to another using Dijkstra's shortest path algorithm. The
 * sample code should help to clarify to users of JGraphT that the class
 * org.jgrapht.alg.shortestpath.DijkstraShortestPath can be used to find
 * shortest paths within directed graphs.
 *
 * @author Minh Van Nguyen
 * @since 2008-01-17
 */

public class T05_Example_grapht {
	public static void main(String args[]) {
		// constructs a directed graph with the specified vertices and edges
		Graph<String, DefaultEdge> directedGraph = new DefaultDirectedGraph<String, DefaultEdge>(
				DefaultEdge.class);
		directedGraph.addVertex("a");
		directedGraph.addVertex("b");
		directedGraph.addVertex("c");
		directedGraph.addVertex("d");
		directedGraph.addVertex("e");
		directedGraph.addVertex("f");
		directedGraph.addVertex("g");
		directedGraph.addVertex("h");
		directedGraph.addVertex("i");
		directedGraph.addEdge("a", "b");
		directedGraph.addEdge("b", "d");
		directedGraph.addEdge("d", "c");
		directedGraph.addEdge("c", "a");
		directedGraph.addEdge("e", "d");
		directedGraph.addEdge("e", "f");
		directedGraph.addEdge("f", "g");
		directedGraph.addEdge("g", "e");
		directedGraph.addEdge("h", "e");
		directedGraph.addEdge("i", "h");

		// computes all the strongly connected components of the directed graph
		StrongConnectivityAlgorithm<String, DefaultEdge> scAlg = new KosarajuStrongConnectivityInspector<>(
				directedGraph);
		List<Set<String>> stronglyConnectedSubgraphs = scAlg.stronglyConnectedSets();

		System.out.println("Strongly connected components:");
		for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++) {
			System.out.println(stronglyConnectedSubgraphs.get(i));
		}
		System.out.println();

		System.out.println("Shortest path from i to c:");
		DijkstraShortestPath<String, DefaultEdge> dijkstraAlg = new DijkstraShortestPath<>(directedGraph);
		SingleSourcePaths<String, DefaultEdge> iPaths = dijkstraAlg.getPaths("i");
		System.out.println(iPaths.getPath("c") + "\n");

		System.out.println("Shortest path from c to i:");
		SingleSourcePaths<String, DefaultEdge> cPaths = dijkstraAlg.getPaths("c");
		System.out.println(cPaths.getPath("i"));
	}
}
