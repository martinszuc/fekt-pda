package cz.vutbr.feec.mpda.examples;

public class T01_MyRunnable {
	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addNode(1, 2);
		g.addNode(6, 1);
		g.addNode(2, 3);
		g.addNode(7, 1);
		g.addNode(7, 6);
		
		g.traversalDFSRecursive(1);
	}
}
