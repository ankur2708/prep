package com.prep.process;

import com.prep.ds.Graph;

public class GraphConnectedComponents {
	
	private final Graph graph;
	
	private final Integer[] vertexComponents;
	
	private final boolean[] isVisited;
	
	private int componentCounter = -1;
	
	public GraphConnectedComponents(final Graph graph)
	{
		this.graph = graph;
		this.vertexComponents = new Integer[this.graph.verticesCount()];
		this.isVisited = new boolean[this.graph.verticesCount()];
		traverse();
	}
	
	private void traverse()
	{
		for(Integer src = 0; src < graph.verticesCount(); src++)
		{
			if(!isVisited[src])
			{
				componentCounter++;
				dfs(src);
			}
		}
	}
	
	private void dfs(final Integer source)
	{
		isVisited[source] = true;
		vertexComponents[source] = componentCounter; 
		for(Integer adjPoint : graph.getAdjacentVertices(source))
		{
			if(!isVisited[adjPoint])
			{
				dfs(adjPoint);
			}
		}
	}
	
	public void printComponents()
	{
		System.out.println("vertex------component");
		for(int vertex = 0; vertex < graph.verticesCount(); vertex++)
		{
			System.out.println(vertex + "------" + vertexComponents[vertex]);
		}
	}

}
