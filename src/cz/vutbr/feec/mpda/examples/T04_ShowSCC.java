package cz.vutbr.feec.mpda.examples;

import javax.swing.JFrame;

import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

public class T04_ShowSCC extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public T04_ShowSCC(String title, boolean showOriginal) {
		DefaultDirectedGraph<String, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

		// add vertices
		graph.addVertex("0");
		graph.addVertex("1");
		graph.addVertex("2");

		if (showOriginal) {
			// original graph edges (from T04_MyRunnable)
			graph.addEdge("2", "0");  // 2 -> 0
			graph.addEdge("2", "1");  // 2 -> 1
			graph.addEdge("0", "1");  // 0 -> 1
			graph.addEdge("1", "0");  // 1 -> 0 (cycle!)
		} else {
			// reversed graph edges
			graph.addEdge("0", "2");  // 0 -> 2 (was 2 -> 0)
			graph.addEdge("1", "2");  // 1 -> 2 (was 2 -> 1)
			graph.addEdge("1", "0");  // 1 -> 0 (was 0 -> 1)
			graph.addEdge("0", "1");  // 0 -> 1 (was 1 -> 0)
		}

		// create graph adapter and layout
		JGraphXAdapter<String, DefaultEdge> jgxAdapter = new JGraphXAdapter<>(graph);
		mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
		getContentPane().add(graphComponent);

		// graph settings
		jgxAdapter.setCellsEditable(false);
		jgxAdapter.setEdgeLabelsMovable(false);
		jgxAdapter.setCellsDeletable(false);
		jgxAdapter.setCellsDisconnectable(false);
		jgxAdapter.setCellsResizable(false);
		jgxAdapter.setCellsBendable(false);
		
		// apply circular layout
		mxCircleLayout layout = new mxCircleLayout(jgxAdapter);
		layout.execute(jgxAdapter.getDefaultParent());
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
	}
	
	public static void main(String[] args) {
		// run the same test as T04
		MyGraph g = new MyGraph();
		g.addNode(2, 0);
		g.addNode(2, 1);
		g.addNode(0, 1);
		g.addNode(1, 0);
		
		java.util.List<java.util.List<MyVertex>> components = SCCKosaraju.scc(g);
		System.out.println("RESULT - Strongly connected components:");
		for (java.util.List<MyVertex> list : components) {
			System.out.println("  " + list);
		}
		
		// show original graph
		T04_ShowSCC originalWindow = new T04_ShowSCC("Original Graph (T04)", true);
		originalWindow.setLocation(100, 100);
		originalWindow.setVisible(true);
		
		// show reversed graph
		T04_ShowSCC reversedWindow = new T04_ShowSCC("Reversed Graph (T04)", false);
		reversedWindow.setLocation(700, 100);
		reversedWindow.setVisible(true);
	}
}

