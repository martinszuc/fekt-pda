package cz.vutbr.feec.MaxFlow;

import java.util.Vector;

/**
 * 
 * @author Martin Rajnoha
 *
 *         trida pro vypocet Maximum Flow
 */
public class MaxFlow {

	private Graph g;
	private Vector<Edge> resEdges = new Vector<>(); // Store residual edges

	public MaxFlow(Graph g) {
		super();
		this.g = g;
	}

	/**
	 * 
	 * @param start
	 * @param sink
	 * @return
	 * @throws FlowNetworkException
	 * 
	 *             tato metoda slouzi na vypocet maximum flow
	 */
	public int computeMaxFlow(String start, String sink) throws FlowNetworkException {
		if (start.equals(sink)) {
			throw new FlowNetworkException("Vertices can not be same!");
		}
		if (!g.isVertexInGraph(start)) {
			throw new FlowNetworkException("Source is not in the network!");
		}
		if (!g.isVertexInGraph(sink)) {
			throw new FlowNetworkException("Sink is not in the network!");
		}
		int maxFlow = 0;
		
		// Edmonds-Karp: Ford-Fulkerson with BFS for path finding
		BFS bfs = new BFS(g);
		Vertex s = g.getVertex(start);
		Vertex t = g.getVertex(sink);
		
		Vector<Edge> path = bfs.getPath(s, t);
		while (path != null) {
			int bottleneck = getBottleneck(path);
			residualPath(g, path, bottleneck);
			maxFlow += bottleneck;
			path = bfs.getPath(s, t);
		}
		
		// Remove all residual edges
		g.getEdges().removeAll(resEdges);
		
		System.out.println("Maximum flow is "+maxFlow);
		return maxFlow;
	}
	
	private void residualPath(Graph g, Vector<Edge> path, int bottleneck) throws FlowNetworkException {
		for (Edge edge : path) {
			edge.setFlow(edge.getFlow() + bottleneck);
			
			Edge backwardEdge = new Edge(edge.getEnd(), edge.getStart(), bottleneck);
			backwardEdge.setFlow(0);
			g.getEdges().add(backwardEdge);
			resEdges.add(backwardEdge);
		}
	}

	
	public int getBottleneck(Vector<Edge> path) {
		int bottleneck = Integer.MAX_VALUE;
		for (Edge edge : path) {
			int residual = edge.getCapacity() - edge.getFlow();
			if (residual < bottleneck) {
				bottleneck = residual;
			}
		}
		System.out.println("Bottleneck is " + bottleneck);
		return bottleneck;
	}
}
