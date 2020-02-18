package com.prep.process;

import java.util.List;

import com.prep.ds.DiGraph;

/**
 * Kosaraju - sharir algorithm.
 * Strong connected vertices are which has path from v-->w and also from w-->v
 * Basically involves two steps:
 * 1) get topological sort on R-Graph
 * 2) DFS on Graph for sequence of vertices got in 1st Step.
 * @author ankur
 *
 */

public class DiGraphStrongConnectedComponents {
	
	private final DiGraph graph;
	
	private final boolean[] visited;
	
	private final Integer[] vertexComponent;
	
	public DiGraphStrongConnectedComponents(final DiGraph graph)
	{
		this.graph = graph;
		this.visited = new boolean[graph.verticesCount()];
		this.vertexComponent = new Integer[graph.verticesCount()];
		process();
	}
	
	private void process()
	{
		TopologicalGraphSort topoSort = new TopologicalGraphSort(graph.reverse());
		List<Integer> topolgySorted = topoSort.getTopology();
		int counter = -1;
		for(Integer point : topolgySorted)
		{
			if(!visited[point])
			{
				counter++;
				dfs(point, counter);
			}
		}
	}
	
	private void dfs(Integer source, int compCounter)
	{
		visited[source] = true;
		vertexComponent[source] = compCounter;
		for(Integer adjPoint : graph.getAdjacentVertices(source))
		{
			if(!visited[adjPoint])
			{
				dfs(adjPoint, compCounter);
			}
		}
		
	}
	
	public void printComponents()
	{
		System.out.println("vertex------component");
		for(int vertex = 0; vertex < graph.verticesCount(); vertex++)
		{
			System.out.println(vertex + "------" + vertexComponent[vertex]);
		}
	}

}
