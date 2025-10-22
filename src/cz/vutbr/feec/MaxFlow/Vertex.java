package cz.vutbr.feec.MaxFlow;

/**
 * 
 * @author Martin Rajnoha
 *
 *         Trida pro vrchol, obsahuje pouze jmeno
 */
public class Vertex {
	private String name;

	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
