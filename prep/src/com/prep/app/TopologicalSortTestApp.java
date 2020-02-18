package com.prep.app;

import com.prep.ds.DiGraph;
import com.prep.process.TopologicalGraphSort;

public class TopologicalSortTestApp {
	
	public static void main(String[] args) {
		
		DiGraph graph = new DiGraph(7);
		
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(1, 4);
		graph.addEdge(3, 4);
		graph.addEdge(6, 0);
		graph.addEdge(3, 5);
		graph.addEdge(3, 2);
		
		TopologicalGraphSort sort = new TopologicalGraphSort(graph);
		sort.printTopology();
		
	}

}
