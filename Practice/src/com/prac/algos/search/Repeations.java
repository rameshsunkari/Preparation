package com.prac.algos.search;

public class Repeations {

	public static void main(String[] args) {
		System.out.println(findOddOccurringNum());
		find2Repeations();
		findFirstRepetition();
		findLastRepetition();
		findRepetitionCount();
	}

	private static int findOddOccurringNum() {

		int[] arr = { 1, 2, 3, 2, 3, 1, 3 };

		int i;
		int res = 0;
		for (i = 0; i < arr.length; i++)
			res = res ^ arr[i];

		return res;
	}

	private static void find2Repeations() {

		int[] arr = { 4, 2, 4, 5, 2, 3, 1 };
		int[] count = new int[arr.length - 2];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - 1]++;
			if (count[arr[i] - 1] > 1) {
				System.out.print(arr[i]);
			}

		}
		System.out.println();

	}
	
	private static void findRepetitionCount() {

		int[] arr = { 1, 2, 2, 3, 4, 4,4, 6 };

		int find = 4;

		int firstIndex = findFirstRepetitionUsingBinarySearch(arr, 0, arr.length-1, find);
		int lastIndex = findLastRepetitionUsingBinarySearch(arr, 0, arr.length-1, find);
		
		int count = lastIndex - firstIndex + 1;
		System.out.println("Count:" + count);
	}

	// Binary Search
	private static void findFirstRepetition() {
		int[] arr = { 1, 2, 2, 3, 4, 4,4, 6 };

		int find = 4;

		int index = findFirstRepetitionUsingBinarySearch(arr, 0,
				arr.length - 1, find);
		System.out.println(index);

	}

	private static int findFirstRepetitionUsingBinarySearch(int[] arr, int low,
			int high, int data) {

		if(high >= low)
		  {
		    int mid = (low + high)/2;  /*low + (high - low)/2;*/
		    if( ( mid == low || data > arr[mid-1]) && arr[mid] == data)
		      return mid;
		    else if(data > arr[mid])
		      return findFirstRepetitionUsingBinarySearch(arr, (mid + 1), high, data);
		    else
		      return findFirstRepetitionUsingBinarySearch(arr, low, (mid -1), data);
		  }
		  return -1;
	}

	// Binary Search
	private static void findLastRepetition() {
		int[] arr = { 1, 2, 2, 3, 4, 4, 4,6 };

		int find = 4;

		int index = findLastRepetitionUsingBinarySearch(arr, 0, arr.length - 1,
				find);
		System.out.println(index);
	}

	private static int findLastRepetitionUsingBinarySearch(int[] arr, int low,
			int high, int data) {

		if(high >= low)
		  {
		    int mid = (low + high)/2;  /*low + (high - low)/2;*/
		    if( ( mid == high || data < arr[mid+1]) && arr[mid] == data )
		      return mid;
		    else if(data < arr[mid])
		      return findLastRepetitionUsingBinarySearch(arr, low, (mid -1), data);
		    else
		      return findLastRepetitionUsingBinarySearch(arr, (mid + 1), high, data);      
		  }
		  return -1;
	}

}
