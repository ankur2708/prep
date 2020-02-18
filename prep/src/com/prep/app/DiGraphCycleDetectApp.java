package com.prep.app;

import com.prep.ds.DiGraph;
import com.prep.process.DiGraphCycleDetect;

public class DiGraphCycleDetectApp {
	
	public static void main(String[] args) {
		
		DiGraph graph = new DiGraph(7);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(5, 3);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);
		graph.addEdge(3, 6);
		graph.addEdge(6, 4);
		graph.addEdge(4, 5);
		
		DiGraphCycleDetect cycleDetect = new DiGraphCycleDetect(graph);
		System.out.println(cycleDetect.getCycle());
		
	}

}
