package cz.vutbr.feec.mpda.examples;

import java.util.ArrayList;

public class MyVertex {
	private ArrayList<MyVertex> neighbours = new ArrayList<>();
	private int id;
	private boolean used = false;
	private int start;
	private int finish;
	
	public void addNeighbour(MyVertex v) {
		neighbours.add(v);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<MyVertex> getNeighbours() {
		return neighbours;
	}

	public void setNeighbors(ArrayList<MyVertex> neighbors) {
		this.neighbours = neighbors;
	}

	public void setUsed(boolean b) {
		this.used = b;
	}

	public boolean isUsed() {
		return used;
	}
	
	@Override
	public String toString() {
		return id + "(u=" + used + ", s=" + start + ", f=" + finish + ")";
	}
	
}
