package cz.vutbr.feec.ukoly;

import cz.vutbr.feec.MaxFlow.FlowNetworkException;
import cz.vutbr.feec.MaxFlow.Graph;
import cz.vutbr.feec.MaxFlow.MaxFlow;

public class P03_executable {

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
		
		MaxFlow mf = new MaxFlow(g);
		mf.computeMaxFlow("s", "t");
		System.out.println(g);

	}

}
