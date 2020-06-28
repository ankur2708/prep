package com.prep.app;

import com.prep.algos.InsertionSort;

public class InsertionSortApp {
	
	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {10,2,5,1,2,3,9,6};
		
		InsertionSort.sort(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "->");
		}
		System.out.println();
		
		
        arr = new Integer[] {1,2,3,4,5,6,7,8,9,10,11};
		
        InsertionSort.sort(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "->");
		}
		System.out.println();
		
	}

}
