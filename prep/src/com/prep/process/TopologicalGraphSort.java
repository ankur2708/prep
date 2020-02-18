package com.prep.process;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.prep.ds.DiGraph;

/**
 * Solves the precedence constraints problems like set of course which can be done only when a 
 * set of course is done!
 * Topological sort is only possible in DAG (Directed acyclic graph)
 * @author ankur
 *
 */
public class TopologicalGraphSort {

	private DiGraph graph;
	
	private boolean[] visited;
	
	private Stack<Integer> sortedTopology = new Stack<Integer>();
	
	public TopologicalGraphSort(final DiGraph graph)
	{
		this.graph = graph;
		this.visited = new boolean[this.graph.verticesCount()];
		sort();
	}
	
	private void sort()
	{
		for(int point = 0; point < this.graph.verticesCount(); point++)
		{
			if(!visited[point])
			{
				dfs(point);
			}
		}
		
	}
	
	private void dfs(final Integer source)
	{
		visited[source] = true;
		for(Integer adjVertex : graph.getAdjacentVertices(source))
		{
			if(!visited[adjVertex])
			{
				dfs(adjVertex);
			}
		}
		//add vertex in stack when there is no outgoing vertex remaining to be visited
		sortedTopology.push(source);
	}
	
	public void printTopology()
	{
		List<Integer> topology = new LinkedList<Integer>();
		sortedTopology.stream().forEach((item)->{topology.add(item);});
		Collections.reverse(topology);
		System.out.println(topology);
	}
	
	public List<Integer> getTopology()
	{
		List<Integer> topology = new LinkedList<Integer>();
		sortedTopology.stream().forEach((item)->{topology.add(item);});
		Collections.reverse(topology);
		return topology;
	}
	
	
	
	
	
}
