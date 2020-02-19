package com.prep.ds;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WeightedGraph {
	
	private List<Edge>[] adjacencyList;
	
	private Integer verticesCount;
	
	public WeightedGraph(int verticesCount)
	{
		this.verticesCount = verticesCount;
		this.adjacencyList = new List[this.verticesCount];
		
		for(int point = 0; point < verticesCount; point++)
		{
			adjacencyList[point] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(final Edge edge)
	{
		int v = edge.either();
		int w = edge.other(v);
		adjacencyList[v].add(edge);
		adjacencyList[w].add(edge);
	}
	
	public Integer verticesCount()
	{
		return verticesCount;
	}
	
	public List<Edge> adjacent(final Integer point)
	{
		return adjacencyList[point];
	}
	
	public Set<Edge> edges()
	{
		Set<Edge> edges = new HashSet<Edge>();
		for(int point = 0; point < verticesCount; point++)
		{
			edges.addAll(adjacencyList[point]);
		}
		return edges;
	}

}
