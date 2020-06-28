package com.prep.app;

import com.prep.algos.MergeSort;

public class MergeSortApp {
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 9;
		arr[4] = 11;
		arr[5] = 7;
		arr[6] = 6;
		arr[7] = 200;
		arr[8] = 0;
		arr[9] = 201;
		
		MergeSort.sort(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "-->");
		}
		System.out.println();
		
	}

}
