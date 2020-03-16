package com.prep.problem;

public class ArrayOperatorOutput {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[8];
		arr[0] = 4;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 5;
		arr[4] = 6;
		arr[5] = 7;
		arr[6] = 8;
		arr[7] = 13;
		
		int output = 121;
		match(arr, arr[0], 1, String.valueOf(arr[0]), output);
	}
	
	public static void match(Integer[] arr,int res, int n, String str, int output)
	{
		if(n == arr.length)
		{
			if(res == output)
			{
				System.out.println(str);
			}
			return;
		}
		match(arr, res + arr[n], n+1, str + "+" + arr[n], output);
		match(arr, res - arr[n], n+1, str + "-" + arr[n], output);
		match(arr, res * arr[n], n+1, str + "*" + arr[n], output);
		match(arr, res / arr[n], n+1, str + "/" + arr[n], output);
		
	}
}
