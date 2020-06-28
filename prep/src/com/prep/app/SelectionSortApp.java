package com.prep.app;

import com.prep.algos.SelectionSort;

public class SelectionSortApp {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {10,2,5,1,2,3,9,6};
		
		SelectionSort.sort(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "->");
		}
		System.out.println();
		
	}
	
}
