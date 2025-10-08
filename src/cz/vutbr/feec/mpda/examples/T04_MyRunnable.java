package cz.vutbr.feec.mpda.examples;

import java.util.List;


public class T04_MyRunnable {
	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addNode(2, 0);
		g.addNode(2, 1);
		g.addNode(0, 1);
		g.addNode(1, 0);
		
		List<List<MyVertex>> components = SCCKosaraju.scc(g);
		System.out.println("RESULT - Strongly connected components:");
		for (List<MyVertex> list : components) {
			System.out.println("  " + list);
		}
	}
}
