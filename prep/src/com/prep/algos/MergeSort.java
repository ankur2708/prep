package com.prep.algos;

public class MergeSort {
	
	public static void sort(Comparable[] arr)
	{
		Comparable[] aux = new Comparable[arr.length];
		sort(arr, aux, 0, arr.length-1);
	}
	
	private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi)
	{
		if(lo == hi)
		{
			return;
		}
		int mid = lo + (hi - lo)/2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid+1, hi);
		merge(arr, aux, lo, mid, hi);
		
	}
	
	private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi)
	{
		for(int x = lo; x <= hi; x++)
		{
			aux[x] = arr[x];
		}
		int j = lo;
		int k = mid+1;
		for(int i = lo; i <= hi; i++)
		{
			if(j > mid)
			{
				arr[i] = aux[k++];
			}
			else if(k > hi)
			{
				arr[i] = aux[j++];
			}
			else
			{
				if(less(k, j, aux))
				{
					arr[i] = aux[k++];
				}
				else
				{
					arr[i] = aux[j++];
				}
			}
			
		}
	}
	
	public static boolean less(int x, int y, Comparable[] arr)
	{
		return arr[x].compareTo(arr[y]) < 0;
	}

}
