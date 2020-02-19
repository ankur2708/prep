package com.prep.algos;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.prep.ds.Edge;
import com.prep.ds.Graph;
import com.prep.ds.WeightedGraph;

/**
 * Kruskal algorithm
 * Minimum spanning tree
 * @author ankur
 *
 */

public class GraphMst {

	private WeightedGraph graph;
	
	private PriorityQueue<Edge> priorityEdge;
	
	private List<Edge> mst;
	
	private Graph cycleGraph;
	
	public GraphMst(final WeightedGraph graph)
	{
		this.graph = graph;
		this.cycleGraph = new Graph(graph.verticesCount());
		mst = new LinkedList<Edge>();
		this.priorityEdge = new PriorityQueue<Edge>();
		priorityEdge.addAll(graph.edges());
		traverse();
	}
	
	private void traverse()
	{
		while(!priorityEdge.isEmpty())
		{
			Edge edge = priorityEdge.poll();
			int v = edge.either();
			int w = edge.other(v);
			if(! checkCycle(v, w))
			{
				cycleGraph.addEdge(v, w);
				mst.add(edge);
			}
		}
	}
	
	private boolean checkCycle(int startPoint, int searchPoint)
	{
		DFS dfs = new DFS(cycleGraph, startPoint);
		return dfs.hasPathTo(searchPoint);
	}
	
	public List<Edge> getMst()
	{
		return mst;
	}
	
	
	
}
