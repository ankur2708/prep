package com.prep.algos;

public class InsertionSort {
	
	public static void sort(Comparable [] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(less(j, j-1, arr))
				{
					swap(j, j-1, arr);
				}
				else
				{
					break;
				}
			}
		}
	}
	
	private static boolean less(int i, int j, Comparable[] arr)
	{
		return arr[i].compareTo(arr[j]) < 0;
	}
	
	private static void swap(int i, int j, Comparable[] arr)
	{
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
