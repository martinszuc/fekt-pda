package cz.vutbr.feec.mpda.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MyGraph {
	private Map<Integer, MyVertex> vertices = new HashMap<>();
	public void addNode(int u1Id, int u2Id) {
		MyVertex v1 = getExistingOrCreateNew(u1Id);
		MyVertex v2 = getExistingOrCreateNew(u2Id);
		
		v1.addNeighbour(v2);
	}
	
	private MyVertex getExistingOrCreateNew(int id) {
		MyVertex v = vertices.get(id);
		if(v == null) {
			v = new MyVertex();
			v.setId(id);
			vertices.put(id, v);
		}
		return v;
	}

	public MyVertex getVertex(int id) {
		return vertices.get(id);
	}

	public void traversalBFS(int nodeToStartWith) {
		LinkedList<MyVertex> list = new LinkedList<>();
		list.addFirst(vertices.get(nodeToStartWith));
		
		HashSet<MyVertex> visited = new HashSet<>();
		visited.add(vertices.get(nodeToStartWith));
		
		while (!list.isEmpty()) {
			MyVertex v = list.removeLast();
			System.out.print(v.getId()+"   ");
			
			for (MyVertex neighbour : v.getNeighbours()) {
				if(!visited.contains(neighbour)) {
					list.addFirst(neighbour);
					visited.add(neighbour);
				}
			}
		}
		System.out.println();
	}

	public void traversalDFS(int nodeToStartWith) {
		System.out.println("TODO");
	}

	public List<MyVertex> getVertexList() {
		return new ArrayList<>(vertices.values());
	}

	public void traversalDFSRecursive(int i) {
		traversalDFSRecursive(vertices.get(i));
	}

	private void traversalDFSRecursive(MyVertex v) {
		if (v == null || v.isUsed()) {
			return;
		}
		
		v.setUsed(true);
		System.out.print(v.getId() + "   ");
		
		for (MyVertex neighbour : v.getNeighbours()) {
			if (!neighbour.isUsed()) {
				traversalDFSRecursive(neighbour);
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer str =  new StringBuffer();
		for (MyVertex v: getVertexList()) {
			str.append(v.getId()+"->"+v.getNeighbours());
		}
		// [[1], [0], [0, 1]]
		return str.toString();
	}
}
