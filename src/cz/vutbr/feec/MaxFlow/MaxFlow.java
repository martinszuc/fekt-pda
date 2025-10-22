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
		// TODO Implement method
		
		
		System.out.println("Maximum flow is "+maxFlow);
		return maxFlow;
	}
	
	private void residualPath(Graph g, Vector<Edge> path, int bottleneck) throws FlowNetworkException {
		// TODO Implement method
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
