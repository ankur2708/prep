package com.prep.ds;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private int totalVertices;
	
	private List<Integer>[] adjacencyList;
	
	public Graph(int totalVertices)
	{
		this.totalVertices = totalVertices;
		this.adjacencyList = new List[totalVertices];
		for(int init = 0; init < totalVertices; init++)
		{
			adjacencyList[init] = new LinkedList<Integer>();
		}
	}
	
	public List<Integer> getAdjacentVertices(final Integer source)
	{
		return adjacencyList[source];
	}
	
	public void addEdge(final Integer start, final Integer end)
	{
		adjacencyList[start].add(end);
		adjacencyList[end].add(start);
	}
	
	public Integer verticesCount()
	{
		return totalVertices;
	}
	
	public Integer edgesCount()
	{
		int count = 0;
		for(List<Integer> vertex : adjacencyList)
		{
			count += vertex.size();
		}
		
		return count/2;
	}

}
