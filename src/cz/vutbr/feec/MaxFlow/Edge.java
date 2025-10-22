package cz.vutbr.feec.MaxFlow;

/**
 * 
 * @author Martin Rajnoha
 *
 *         Trida pro hranu grafu
 */

public class Edge {

	private Vertex start;
	private Vertex end;
	private int capacity; // maximalni vaha hrany
	private int flow; // aktualni vaha hrany

	public Edge(Vertex start, Vertex end, int capacity) {
		this.start = start;
		this.end = end;
		this.capacity = capacity;
	}

	public Vertex getStart() {
		return start;
	}

	public Vertex getEnd() {
		return end;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) throws FlowNetworkException {
		if(flow > capacity){
			throw new FlowNetworkException("Can not set flow bigger than capacity");
		}
		this.flow = flow;
	}

	@Override
	public String toString() {
		return "[" + start + "->" + end + ", " + flow + "/" + capacity + "]";
	}
}
