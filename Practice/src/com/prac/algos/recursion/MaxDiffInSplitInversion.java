package com.prac.algos.recursion;

public class MaxDiffInSplitInversion {

	public static void main(String[] args) {
//		 int[] arr = {1,2,3,4,5};
		 int[] arr = {5,4,3,2,1};
//		int[] arr = {5, 4, 1, 6, 3};
		System.out.println(maxDiff1(arr));
		System.out.println(maxDiff(arr));

	}

	private static int maxDiff1(int[] arr) {
		int i = 0, min = 0, max = -1;
		for (i = 0; i < arr.length; i++) {
			int diff = arr[i] - arr[min];
			
			if (diff < 0)
				min = i;
			else {
				if (diff > max) {
					max = diff;
				}
			}
		}
		return max;
	}

	private static int maxDiff(int[] arr) {
		int maxDiff = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int diff = arr[j] - arr[i];
				if (diff > 0 && maxDiff < diff) {
					maxDiff = diff;
				}
			}
		}

		return maxDiff;
	}

}
