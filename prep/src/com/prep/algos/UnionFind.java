package com.prep.algos;
/**
 * Quick Union find with Path compression and union optimization
 * Union-- O(log n)
 * Find -- O(log n)
 * @author ankur
 *
 */
public class UnionFind {

	private int[] points;
	private int[] size;
	
	public UnionFind(int numOfPoints)
	{
		points = new int[numOfPoints];
		size = new int[numOfPoints];
		for(int i = 0; i < numOfPoints; i++)
		{
			points[i] = i;
		}
	}
	
	public boolean connected(int point1, int point2)
	{
		validate(point1, point2);
		return getRoot(point1) == getRoot(point2);
	}
	
	public void union(int point1, int point2)
	{
		validate(point1, point2);
		int root1 = getRoot(point1);
		int root2 = getRoot(point2);
		if(root1 == root2) 
		{
			return;
		}
		if(size[root1] >= size[root2])
		{
			points[root1] = root2;
		}
		
	}
	
	private int getRoot(int point)
	{
		while(points[point] != point)
		{
			points[point] = points[points[point]]; // this line not required, but it improves time complexity by path compression!!
			point = points[point];
		}
		return point;
	}
	
	private void validate(int point1, int point2)
	{
		if(point1 < 0 || point2 < 0 || point1 > points.length - 1 || point2 > points.length -1)
		{
			throw new IllegalArgumentException("No such point!");
		}
	}
	
}
