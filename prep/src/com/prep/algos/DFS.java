package com.prep.algos;

import java.util.Stack;

import com.prep.ds.Graph;

public class DFS {
	
	private Graph graph;
	
	private Integer startPoint;
	
	private boolean[] isVisited;
	
	private Integer[] fromVertex;
	
	public DFS(final Graph graph, final Integer startPoint)
	{
		this.graph = graph;
		this.startPoint = startPoint;
		this.isVisited = new boolean[this.graph.verticesCount()];
		this.fromVertex = new Integer[this.graph.verticesCount()];
		traverse();
		//traverseUsingStack();
	}
	
	private void traverse()
	{
		recursiveTraverse(startPoint);	
	}
	
	private void traverseUsingStack()
	{
		Stack<Integer> expandVertex = new Stack<Integer>();
		expandVertex.push(startPoint);
		isVisited[startPoint] = true;
		
		while(!expandVertex.isEmpty())
		{
			Integer expandPoint = expandVertex.pop();
			System.out.println("DFS: graph expandng for point:" + expandPoint);
			for(Integer adjPoint : graph.getAdjacentVertices(expandPoint))
			{
				if(!isVisited[adjPoint])
				{
					expandVertex.push(adjPoint);
					isVisited[adjPoint] = true;
					fromVertex[adjPoint] = expandPoint; 
				}
			}
		
		}
	}
	
	private void recursiveTraverse(final Integer point)
	{
		System.out.println("DFS: graph expandng for point:" + point);
		isVisited[point] = true;
		for(Integer adjPoint : graph.getAdjacentVertices(point))
		{
			if(!isVisited[adjPoint])
			{
				fromVertex[adjPoint] = point;
				recursiveTraverse(adjPoint);
			}
		}
	}
	
	public boolean hasPathTo(final Integer destPoint)
	{
		return isVisited[destPoint];
	}
	
	public Stack<Integer> pathTo(final Integer destPoint)
	{
		Stack<Integer> pathStacked = new Stack<Integer>();
		if(!hasPathTo(destPoint))
		{
			return pathStacked;
		}
		
		for(Integer point = destPoint; point != null; point = fromVertex[point])
		{
			pathStacked.push(point);
		}
		
		return pathStacked;
	}
	
	

}
