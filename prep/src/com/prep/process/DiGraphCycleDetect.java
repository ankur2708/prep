package com.prep.process;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.prep.ds.DiGraph;

public class DiGraphCycleDetect {
	
	private final DiGraph graph;
	
	private final boolean[] visited;
	
	private Integer[] fromVertex;
	
	private boolean[] onStack;
	
	private List<Integer> cycle;
	
	public DiGraphCycleDetect(final DiGraph graph)
	{
		this.graph = graph;
		this.visited = new boolean[graph.verticesCount()];
		this.fromVertex = new Integer[graph.verticesCount()];
		this.onStack = new boolean[graph.verticesCount()];
		for(Integer point = 0; point < graph.verticesCount(); point++)
		{
			if(!visited[point])
			{
				dfs(point);
			}
		}
	}
	
	private void dfs(Integer point)
	{
		visited[point] = true;
		onStack[point] = true;
		for(Integer adjPoint : graph.getAdjacentVertices(point))
		{
			if(!visited[adjPoint])
			{
				fromVertex[adjPoint] = point;
				dfs(adjPoint);
			}
			else if(onStack[adjPoint])
			{
				cycle = new LinkedList<Integer>();
				cycle.add(adjPoint);
				for(Integer itPoint = point; itPoint != adjPoint; itPoint = fromVertex[itPoint]) 
				{
					cycle.add(itPoint);
				}
				cycle.add(adjPoint);
				return;
			}
		}
		onStack[point] = false;
	}
	
	public List<Integer> getCycle()
	{
		List<Integer> cycleReturn = new LinkedList<Integer>();
		cycle.forEach((item) -> {cycleReturn.add(item);});
		Collections.reverse(cycleReturn);
		return cycleReturn;
	}

}
