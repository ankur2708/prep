package com.prep.algos;

/**
 * Quick sort for array of any comparable items.
 * Time complexity on Avg case : O(nlogn).
 * Recommended to Shuffle the array before sorting to avoid worst case time complexity O(n^2)
 * @author ankur
 *
 */
public class QuickSort {
	
	public static void sort(Comparable[] items) {
		sort(items, 0, items.length - 1);
	}
	
	public static void sort(Comparable[] items, int lo, int hi) {
		if(lo >= hi) return;
		int part = partition(items, lo, hi);
		sort(items, lo, part - 1);
		sort(items, part + 1, hi);
	}
	
	public static int partition(Comparable[] items, int lo, int hi) {
		Comparable pivot = items[lo];
		int lidx = lo;
		int ridx = hi + 1;
		while(true) {
			while(less(items[++lidx], pivot)) {
				if(lidx == hi) break;
			}
			while(less(pivot, items[--ridx])) {
				if(ridx == lo) break;
			}
			if(lidx >= ridx) break;
			swap(items, lidx, ridx);
		}
		swap(items, lo, ridx);
		return ridx;
	}
	
	public static boolean less(Comparable left, Comparable right) {
		return left.compareTo(right) < 0;
	}
	
	public static void swap(Comparable[] items, int x, int y) {
		Comparable temp = items[x];
		items[x] = items[y];
		items[y] = temp;
	}

}
