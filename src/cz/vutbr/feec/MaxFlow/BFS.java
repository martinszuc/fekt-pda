package cz.vutbr.feec.MaxFlow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

/**
 * 
 * @author Martin Rajnoha
 * 
 *         trida na vyhladavani cest pomoci BFS algoritmu
 */
public class BFS {

	private Graph g;
	// mapa na zpetne zrekonstruovani cesty
	private HashMap<Vertex, Vertex> backTrace = new HashMap<>();

	public BFS(Graph g) {
		this.g = g;
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 * 
	 * 		vrati cestu pomoci BFS
	 */
	public Vector<Edge> getPath(Vertex start, Vertex end) {
		backTrace.clear();
		LinkedList<Vertex> open = new LinkedList<Vertex>();
		HashSet<Vertex> closed = new HashSet<Vertex>();

		open.add(start);
		while (!open.isEmpty()) {
			Vertex tmp = open.remove();
			closed.add(tmp);
			// vrati vektor sousedu, ke kterym je mozne se dostat
			Vector<Vertex> possibleVertices = g.getPossibleNeighbors(tmp);
			for (Vertex vertex : possibleVertices) {
				if (vertex == end) { // cesta je v cili
					backTrace.put(vertex, tmp);
					Vector<Edge> path = constructPath(start, end);
					System.out.println("Path between '"+start.getName()+"' and '"+end.getName()+"' is "+path);
					return path;
				}
				if (!closed.contains(vertex)) {
					open.add(vertex);
					backTrace.put(vertex, tmp);
				}
			}
		}
		return null; // zadna cesta
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 * 
	 * 		zpetne rekonstruuje cestu resp. sklada hrany - neni to serazene,
	 *         pro vypocet MaxFlow to nevadi
	 */
	private Vector<Edge> constructPath(Vertex start, Vertex end) {
		Vector<Edge> path = new Vector<>();
		Vertex v1 = end;
		Vertex v2 = end;
		while (v1 != start) {
			v1 = backTrace.get(v2);
			path.add(0,g.getEdge(v1, v2));
			v2 = v1;
		}
		return path;
	}

}
