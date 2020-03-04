package com.prep.app;

import java.util.Arrays;

import com.prep.algos.LsdRadixSort;

public class LsdRadixSortTestApp {
	
	public static void main(String[] args) {
		
		String [] strArr = new String[9];
		
		strArr[0] = "bad";
		strArr[1] = "xbb";
		strArr[2] = "yab";
		strArr[3] = "zyaaaa"; // going to sort on basis of first 3 chars only
		strArr[4] = "zaa";
		strArr[5] = "abd";
		strArr[6] = "dab";
		strArr[7] = "adb";
		strArr[8] = "dba";
		
		System.out.println("before sort:" + Arrays.toString(strArr));
		
		LsdRadixSort.sort(strArr, 3);
		
		System.out.println("after sort:" + Arrays.toString(strArr));
		
	}

}
