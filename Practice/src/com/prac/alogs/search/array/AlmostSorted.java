package com.prac.alogs.search.array;

import java.util.Arrays;

public class AlmostSorted {

	public static void main(String[] args) {
//		int arr[] = {90,15, 20,23, 30, 40, 50,10};
		int arr[] = {9,15, 20,33, 30, 40, 50,70};
		System.out.println(Arrays.toString(arr));
		prepareSortedArrayV1(arr);
//		prepareSortedArray(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	private static void prepareSortedArrayV1(int[] arr) {
		
		boolean found = false;
		int elem1=0,elem2=0;
		for (int i = 0; i < arr.length; i++) {
			if (!found && arr[i] > arr[i+1]) {
				elem1 = i;
				found = true;
			} else if (found && arr[elem1] > arr[i]) {
				elem2 = i;
			}
		}
		
		int temp = arr[elem1];
		arr[elem1] = arr[elem2];
		arr[elem2] = temp;
 		
	}

	private static void prepareSortedArray(int[] arr) {
		int i = 0, elem1=0, elem2=0;
		int n = arr.length;
		boolean found = false;
		
		for (i=0; i < n; i++) {
			
			if (arr[i] > arr[i+1]) {
				System.out.println("1."+arr[i]);
				elem1 = i;
			}
			
			for (int j=i+1; j<n;j++) {
				if (arr[j] < arr[elem1]) {
					System.out.println("2."+arr[j]);
					elem2=j;
					found = true;
				}
			}
			
			if (found) {
				break;
			}
		}
		
		int temp = arr[elem1];
		arr[elem1] = arr[elem2];
		arr[elem2] = temp;
 	}
}
