package cz.vutbr.feec.MaxFlow;

import java.util.HashMap;
import java.util.Vector;

/**
 * 
 * @author Martin Rajnoha
 *
 *         trida pro Graf
 */
public class Graph {

	private HashMap<String, Vertex> vertices = new HashMap<>();
	private Vector<Edge> edges = new Vector<>();

	public Vertex getVertex(String name) {
		return vertices.get(name);
	}

	public Vector<Edge> getEdges() {
		return edges;
	}

	public boolean isVertexInGraph(String name) {
		if (vertices.containsKey(name)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @param capacity
	 * @throws FlowNetworkException
	 * 
	 *             prida hranu do grafu, pouzije stavajici vrcholy, nebo vytvori
	 *             nove
	 */
	public void addToGraph(String v1, String v2, int capacity) throws FlowNetworkException {
		if (v1.equals(v2)) {
			throw new FlowNetworkException("Cannot have same start and end!");
		}
		if (capacity < 0) {
			throw new FlowNetworkException("Capacity can not be negative!");
		}
		Vertex vertex1;
		Vertex vertex2;
		if (isVertexInGraph(v1)) {
			vertex1 = getVertex(v1);
		} else {
			vertex1 = new Vertex(v1);
			vertices.put(v1, vertex1);
		}
		if (isVertexInGraph(v2)) {
			vertex2 = getVertex(v2);
		} else {
			vertex2 = new Vertex(v2);
			vertices.put(v2, vertex2);
		}
		if (getEdge(vertex1, vertex2) != null) {
			throw new FlowNetworkException("Edge already exists in graph!");
		}
		Edge e = new Edge(vertex1, vertex2, capacity);
		edges.add(e);
	}

	/**
	 * 
	 * @param start
	 * @return
	 * 
	 * 		vrati seznam sousedu, ke kterym vede hrana
	 */
	// TODO tuhle metodu je potreba jednoduse upravit pro potreby MaxFlow tj.
	// aby byly uvažovány jenom hrany s volnou kapacitou
	public Vector<Vertex> getPossibleNeighbors(Vertex start) {
		Vector<Vertex> possibleEdges = new Vector<>();
		for (Edge edge : edges) {
			// iteruje pres vsechny hrany grafu
			if (edge.getStart() == start) {
				// kdyz najde hranu ktera vychazi z daneho vrcholu, prida ji do
				// seznamu
				possibleEdges.add(edge.getEnd());
			}
		}
		return possibleEdges;
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 * 
	 * 		vrati hranu na zaklade dvou vrcholu
	 */
	public Edge getEdge(Vertex start, Vertex end) {
		for (Edge edge : edges) {
			if (edge.getStart() == start && edge.getEnd() == end) {
				return edge;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws FlowNetworkException
	 * 
	 *             vrati hranu na zaklade jmen vrcholu
	 */
	public Edge getEdge(String start, String end) throws FlowNetworkException {
		if (start.equals(end)) {
			throw new FlowNetworkException("Vertices can not be same!");
		}
		if (!isVertexInGraph(start)) {
			throw new FlowNetworkException("Source is not in the network!");
		}
		if (!isVertexInGraph(end)) {
			throw new FlowNetworkException("End is not in the network!");
		}

		return getEdge(getVertex(start), getVertex(end));

	}

	@Override
	public String toString() {
		return "Graph [vertices= " + vertices.keySet() + ", edges=" + edges + "]";
	}
}
