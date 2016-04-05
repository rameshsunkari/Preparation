package com.prac.alogs.types.dp;

public class RodCutProblem {

	public static void main(String[] args) {
		RodCutProblem rc = new RodCutProblem();
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(rc.findMaxProfit(arr, arr.length));
		System.out.println(rc.findMaxProfitBottomUp(arr));

	}

	private int findMaxProfit(int[] arr, int n) {
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;

		// Recursively cut the rod in different pieces and compare different
		// configurations
		for (int i = 0; i < n; i++)
			max_val = Math.max(max_val, arr[i] + findMaxProfit(arr, n - i - 1));

		return max_val;

	}
	
	private int findMaxProfitBottomUp(int[] price) {
		int max[] = new int[price.length+1];
		for(int i=1;i<=price.length;i++) {
			max[i] = price[i-1];
		}
		
		for (int i=1;i<=price.length;i++) {
			for (int j=1;j<i;j++) {
				max[i] = Math.max(max[i], max[i-j] + max[j]);
			}
		}
		
		
		return max[price.length];
	}

}
