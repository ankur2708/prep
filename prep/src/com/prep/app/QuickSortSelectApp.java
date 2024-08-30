package com.prep.app;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.prep.algos.QuickSelect;
import com.prep.algos.QuickSort;

public class QuickSortSelectApp {
	public static void main(String[] args) {
		int[] arr = new int[] {10, 2, 8, 4, 1, 15, 6};
		Integer[] arrInt = IntStream.of(arr).boxed().toArray(Integer[]:: new);
		QuickSort.sort(arrInt);
		System.out.println("print arr:" + Arrays.toString(arrInt));
		
		arrInt = IntStream.of(arr).boxed().toArray(Integer[]:: new);
		System.out.println("Kth largest: " + QuickSelect.getKthLargest(arrInt, 6));
	}
}
