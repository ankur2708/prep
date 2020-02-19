package com.prep.ds;

public class Edge implements Comparable<Edge> {
	
	private final Integer v;
	
	private final Integer w;
	
	private final double weight;
	
	public Edge(final Integer v, final Integer w, final double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public Integer either()
	{
		return v;
	}
	
	public Integer other(Integer oneEnd)
	{
		if(v == oneEnd)
		{
			return w;
		}
		else
		{
			return v;
		}
	}
	
	public double weight()
	{
		return weight;
	}

	@Override
	public int compareTo(final Edge that) {
		return this.weight < that.weight ? -1 : this.weight > that.weight ? 1 : 0;
	}
	
	public String toString()
	{
		return v + "<-->" + w;
	}

}
