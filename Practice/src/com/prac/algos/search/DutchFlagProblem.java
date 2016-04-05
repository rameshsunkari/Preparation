package com.prac.algos.search;

import java.util.Arrays;

public class DutchFlagProblem {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		rearrageArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	private static void rearrageArray(int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}
}
