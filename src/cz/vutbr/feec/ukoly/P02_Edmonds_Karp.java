package cz.vutbr.feec.ukoly;

import java.util.Vector;

import cz.vutbr.feec.MaxFlow.BFS;
import cz.vutbr.feec.MaxFlow.Edge;
import cz.vutbr.feec.MaxFlow.FlowNetworkException;
import cz.vutbr.feec.MaxFlow.Graph;
import cz.vutbr.feec.MaxFlow.MaxFlow;
import cz.vutbr.feec.MaxFlow.Vertex;

public class P02_Edmonds_Karp {

	public static void main(String[] args) throws FlowNetworkException {
		Graph g = new Graph();
		g.addToGraph("s", "a", 13);
		g.addToGraph("s", "c", 10);
		g.addToGraph("a", "b", 5);
		g.addToGraph("b", "c", 50);
		g.addToGraph("c", "d", 35);
		g.addToGraph("b", "t", 3);
		g.addToGraph("d", "t", 20);

		System.out.println(g);

		BFS bfs = new BFS(g);
		Vertex s = g.getVertex("s");
		Vertex t = g.getVertex("t");
		Vector<Edge> path = bfs.getPath(s, t);
		MaxFlow mf = new MaxFlow(g);
		
		int bottleneck = mf.getBottleneck(path);
		
		for (Edge edge : path) {
			edge.setFlow(edge.getFlow() + bottleneck);
		}
		
		System.out.println(g);

	}

}
