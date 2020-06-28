package com.prep.algos;

public class SelectionSort {
	
	public static void sort(Comparable [] items)
	{
		for(int i = 0; i < items.length; i++)
		{
			int min = i;
			for(int j = i; j < items.length; j++)
			{
				if(less(j, min, items))
				{
					min = j;
				}
			}
			swap(i, min, items);
		}
	}
	
	private static boolean less(int j, int min, Comparable [] items)
	{
		return items[j].compareTo(items[min]) < 0;
	}
	
	private static void swap(int i, int min, Comparable[] items)
	{
		Comparable temp = items[i];
		items[i] = items[min];
		items[min] = temp;
	}

}
