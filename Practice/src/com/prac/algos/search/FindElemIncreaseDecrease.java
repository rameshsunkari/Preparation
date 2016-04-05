package com.prac.algos.search;

public class FindElemIncreaseDecrease {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 50, 10, 9, 7, 6 };
		System.out.println(findMaximum(arr, 0, arr.length - 1));
		System.out.println(findElemInSeries(arr, 0, arr.length - 1));
	}

	private static int findElemInSeries(int[] arr, int low, int high) {
		int num = -1;

		
		while (low <= high) {
			if (low == high) {
				return arr[low];
			} else if (low + 1 == high) {
				return Math.max(arr[low], arr[high]);
			}
			int mid = low + (high - low) / 2;

			// 
			if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
				return arr[mid];
			} 
			
			if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return num;
	}

	private static int findMaximum(int arr[], int low, int high) {

		/* Base Case: Only one element is present in arr[low..high] */
		if (low == high)
			return arr[low];

		/* If there are two elements and return the max of two */
		if ((high == low + 1)) {
			return Math.max(arr[low], arr[high]);
		}

		int mid = low + (high - low) / 2; /* low + (high - low)/2; */

		/*
		 * If we reach a point where arr[mid] is greater than both of its
		 * adjacent elements arr[mid-1] and arr[mid+1], then arr[mid] is the
		 * maximum element
		 */
		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
			return arr[mid];

		/*
		 * If arr[mid] is greater than the next element and smaller than the
		 * previous element then maximum lies on left side of mid
		 */
		if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
			return findMaximum(arr, low, mid - 1);
		else
			// when arr[mid] is greater than arr[mid-1] and smaller than
			// arr[mid+1]
			return findMaximum(arr, mid + 1, high);
	}

}
