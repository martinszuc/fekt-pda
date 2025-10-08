package cz.vutbr.feec.mpda.examples;

public class T02_ReverseGraphExample {
	public static void main(String[] args) {
		MyGraph graph = new MyGraph();
		graph.addNode(1, 2);
		graph.addNode(6, 1);
		graph.addNode(2, 3);
		graph.addNode(7, 1);
		graph.addNode(7, 6);
		
		MyGraph reversedGraph = new MyGraph();
		
		System.out.println("UKOL: Vytvoøte algoritmus, který vytvoøí z graph reverzní graf");
	}
}
