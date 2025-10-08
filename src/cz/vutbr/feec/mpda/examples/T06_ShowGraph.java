package cz.vutbr.feec.mpda.examples;

import java.util.Collection;

import javax.swing.JFrame;

import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.AbstractGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;


public class T06_ShowGraph extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public T06_ShowGraph() {
		JGraphXAdapter<String, DefaultEdge> jgxAdapter;
		AbstractGraph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

		graph.addVertex("v1");
		graph.addVertex("v2");
		graph.addVertex("v3");
		graph.addVertex("v4");

		graph.addEdge("v1", "v2");
		graph.addEdge("v2", "v3");
		graph.addEdge("v3", "v4");
		//graph.addEdge("v4", "v1");

		jgxAdapter = new JGraphXAdapter<String, DefaultEdge>(graph);
		mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
		mxGraphModel graphModel = (mxGraphModel) graphComponent.getGraph().getModel();
		Collection<Object> cells = graphModel.getCells().values();
		// mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), cells.toArray(), mxConstants.STYLE_ENDARROW, mxConstants.NONE);
		getContentPane().add(graphComponent);

		jgxAdapter.setCellsEditable(false);
		//jgxAdapter.setCellsMovable(false);
		jgxAdapter.setEdgeLabelsMovable(false);
		jgxAdapter.setCellsDeletable(false);
		jgxAdapter.setCellsDisconnectable(false);
		jgxAdapter.setCellsResizable(false);
		jgxAdapter.setCellsBendable(false);
		
		mxCircleLayout layout = new mxCircleLayout(jgxAdapter);
		layout.execute(jgxAdapter.getDefaultParent());
	}
	
	public static void main(String[] args) {
		T06_ShowGraph g = new T06_ShowGraph();
		g.setTitle(" undirected graph ");
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.pack();
		g.setVisible(true);
	}


}
