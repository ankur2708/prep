package com.prep.app;

import com.prep.ds.DiGraph;
import com.prep.process.DiGraphStrongConnectedComponents;

public class DiGraphStrongConnectedCompTestApp {
	
	public static void main(String[] args) {
		
		DiGraph graph = new DiGraph(13);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 5);
		graph.addEdge(3, 2);
		graph.addEdge(4, 3);
		graph.addEdge(4, 2);
		graph.addEdge(5, 4);
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(7, 6);
		graph.addEdge(7, 9);
		graph.addEdge(8, 6);
		graph.addEdge(9, 11);
		graph.addEdge(9, 10);
		graph.addEdge(10, 12);
		graph.addEdge(12, 9);
		graph.addEdge(11, 12);
		
		DiGraphStrongConnectedComponents connComp = new DiGraphStrongConnectedComponents(graph);
		
		connComp.printComponents();
		
		
		
	}

}
