package com.prep.ds;

import java.util.LinkedList;
import java.util.List;

public class DiGraph {
	
	private final int totalVertices;
	
	private final List<Integer>[] adjacencyList;
	
	public DiGraph(int totalVertices)
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
		
		return count;
	}
	
	public DiGraph reverse()
	{
		DiGraph reverseDiGraph = new DiGraph(this.totalVertices);
		for(Integer vertex = 0; vertex < this.totalVertices; vertex++)
		{
			for(Integer adjPoint : this.adjacencyList[vertex])
			{
				reverseDiGraph.addEdge(adjPoint, vertex);
			}
		}
		
		return reverseDiGraph;
	}

}
