package com.prep.algos;

import java.util.Arrays;

/**
 * can be used to sort fix width Strings
 * can be used to sort integers too.
 * time complexity: W*N [where W is width of String/Integer and N is number of elements]
 * @author ankur
 *
 */
public class LsdRadixSort {
	
	
	public static void sort(String[] stringArr, int fixedWidth)
	{
		//considering characters in String to be of 1 byte (8 bits), while in java it could be 2 bytes!
		int R = 256;
		int N = stringArr.length;
		String[] aux = new String[N];
		
		for(int i = fixedWidth -1; i >= 0; i--)
		{
			int[] count = new int[R+1];
			//counting the chars at +1 index
			for(int strInd = 0; strInd < N; strInd++)
			{
				count[stringArr[strInd].charAt(i) + 1]++; 
			}
			
			//counting how many bigger/smaller than the char in question
			for(int x = 1; x < count.length; x++)
			{
				count[x] += count[x-1];
			}
			
			//putting original String to aux in position as per the count
			for(int y = 0; y < N; y++)
			{
				aux[count[stringArr[y].charAt(i)]++] = stringArr[y]; 
			}
			
			//copying back to original array?
			for(int z = 0; z < N; z++)
			{
				stringArr[z] = aux[z];
			}
			System.out.println("after iteration " + i+ ":" + Arrays.toString(stringArr));
		}
		
	}

}
