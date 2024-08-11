package com.prep.algos;

import java.util.LinkedList;
import java.util.List;

import com.prep.ds.Graph;

public class BFS {
	
	private Graph graph;
	
	private Integer startPoint;
	
	private boolean[] isVisited;
	
	private Integer[] fromVertex;
	
	public BFS(final Graph graph, int startPoint)
	{
		this.graph = graph;
		this.startPoint = startPoint;
		this.isVisited = new boolean[this.graph.verticesCount()];
		this.fromVertex = new Integer[this.graph.verticesCount()];
		traverse();
	}
	
	private void traverse()
	{
		LinkedList<Integer> points = new LinkedList<Integer>();
		points.add(startPoint); //adds in the tail
		isVisited[startPoint] = true;
		while(!points.isEmpty())
		{
			Integer expandPoint = points.remove(); //removes from the head
			
			System.out.println("BFS: graph expandng for point:" + expandPoint);
			for(Integer adjPoint : graph.getAdjacentVertices(expandPoint))
			{
				if(!isVisited[adjPoint])
				{
					points.add(adjPoint);
					isVisited[adjPoint] = true;
					fromVertex[adjPoint] = expandPoint;
				}
			}	
		}
	}
	
	public boolean hasPathTo(final Integer destPoint)
	{
		return isVisited[destPoint];
	}
	
	public List<Integer> pathTo(final Integer destPoint)
	{
		List<Integer> path = new LinkedList<Integer>();
		if(!hasPathTo(destPoint))
		{
			return path;
		}
		for(Integer point = destPoint; point != null; point = fromVertex[point])
		{
			path.add(point);
		}
		return path;
	}
	
	

}
