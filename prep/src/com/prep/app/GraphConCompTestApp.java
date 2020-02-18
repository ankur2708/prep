package com.prep.app;

import com.prep.ds.Graph;
import com.prep.process.GraphConnectedComponents;

public class GraphConCompTestApp {
	
	public static void main(String[] args) {
		
		Graph graph = new Graph(12);
		
		graph.addEdge(0, 2);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(5, 3);
		graph.addEdge(6, 4);
		graph.addEdge(0, 5);
		graph.addEdge(4, 5);
		graph.addEdge(0, 6);
		
		graph.addEdge(7, 8);
		graph.addEdge(7, 9);
		
		graph.addEdge(10, 10);
		graph.addEdge(11, 11);
		
		System.out.println("graph edges count:" + graph.edgesCount());
		System.out.println("graph vertices count:" + graph.verticesCount());
		
		GraphConnectedComponents comp = new GraphConnectedComponents(graph);
		
		comp.printComponents();
		
	}

}
