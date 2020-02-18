package com.prep.app;

import com.prep.algos.BFS;
import com.prep.ds.Graph;

public class BfsTestApp {
	
	public static void main(String[] args) {
		
		Graph graph = new Graph(7);
		
		graph.addEdge(0, 2);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(5, 3);
		graph.addEdge(6, 4);
		graph.addEdge(0, 5);
		graph.addEdge(4, 5);
		graph.addEdge(0, 6);
		
		System.out.println("graph edges count:" + graph.edgesCount());
		System.out.println("graph vertices count:" + graph.verticesCount());
		
		BFS dfs = new BFS(graph, 0);
		
		System.out.println(dfs.pathTo(4));
		
		
	}

}
