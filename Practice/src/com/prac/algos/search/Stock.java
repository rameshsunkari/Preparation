package com.prac.algos.search;

public class Stock {

	public static void main(String[] args) {
		// int[] a = {10,90,67,54,32};
		int[] a = { 5, 4, 1, 6, 3 };
		int[] arr = {5,4,3,2,1};
		System.out.println("Max Diff = " + findMaxDiff(a));
		System.out.println("Max Diff = " + findMaxDiff(arr));
	}

	private static int findMaxDiff(int[] arr) {
		int i = 0, buy = 0, sell = 0, min = 0, profit = -1;

		for (i = 0; i < arr.length; i++) {
			int diff = arr[i] - arr[min];
			if (arr[i] <  arr[min])
				min = i;
			else if (diff > profit) {
				buy = min;
				sell = i;
				profit = diff;
			}
		}
		System.out.println("Profit is " + profit+ " if brought at : "  + buy + " and sell :" + sell);
		return profit;
	}

}
