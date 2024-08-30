package com.prep.algos;

/**
 * Getting kth largest element in array.
 * Relies on quick sort partition, which put pivot element at correct index position in array.
 * @author ankur
 *
 */
public class QuickSelect {
	
	public static Comparable getKthLargest(Comparable[] items, int k) {
		return getKthLargest(items, k, 0, items.length - 1);
	}
	
	private static Comparable getKthLargest(Comparable[] items, int k, int lo, int hi) {
		while(lo < hi) {
			int part = QuickSort.partition(items, lo, hi);
			if(part < k) lo = part + 1;
			else if (part > k) hi = part - 1;
			else return items[k];
		}
		// only case when lo == hi, which wud mean k = lo or hi
		return items[k];
	}

}
