package com.prac.algos.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
//		int[] arr = { 6, 3, 2, 1, 5, 4 };
		int[] arr = {2, 4, 6, 8, 3};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/*public static void main(String[] args) {

		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		insertionSort(input);
	}*/

	private static void printNumbers(int[] input) {

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println("");
	}

	public static void insertionSort(int array[]) {
		int n = array.length;
		if (n<=1) {
			return;
		}
		int count = 0;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
				count++;
			}
			array[i + 1] = key;
			
		}
		
		System.out.println(count);
	}

}
