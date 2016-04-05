package com.prac.algos.search;

import java.util.Arrays;

public class SumClosestToZero {

	public static void main(String[] args) {
		int[] arr = {1, 60, -10, 70, -80, 85};
		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
		
		int low =0;
		int high=arr.length-1;
		Arrays.sort(arr);
		int i=-1,j=-1;
		while(low<high) {
			
			int sum = arr[low]+arr[high];
			
			if (Math.abs(sum)<Math.abs(min)) {
				min = sum;
				i=low;
				j=high;
			} 
			if (sum <0) {
				low++;
			}
			else {
				high--;
			}
				
		}
		
		System.out.println(arr[i] + "\t"+arr[j] + "\t" + min);
	}

}
