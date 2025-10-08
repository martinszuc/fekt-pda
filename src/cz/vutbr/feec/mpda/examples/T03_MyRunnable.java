package cz.vutbr.feec.mpda.examples;

import java.util.LinkedList;


public class T03_MyRunnable {
	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addNode(2, 0);
		g.addNode(2, 1);
		g.addNode(0, 1);
		g.addNode(1, 0);
		System.out.println(g);
		
		LinkedList<MyVertex> result = SCCKosaraju.dfsRecursive(g.getVertex(0));
		System.out.println(result);

	}
}
