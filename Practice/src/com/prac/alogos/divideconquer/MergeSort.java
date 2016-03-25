package com.prac.alogos.divideconquer;

import java.util.Arrays;

public class MergeSort {

	// private static int arr[] = { 5, 4, 8, 1, 7, 2, 6, 3 };
//	private static int arr[] = { 6, 5, 4, 3, 2, 1 };
    private static int arr[] = { 5, 4 };
	private static int arr1[] = Arrays.copyOf(arr, arr.length);

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		doMergesort(0, arr.length - 1);
		System.out.println("Time Taken : " + (System.currentTimeMillis() - start));
		display(arr);
		start = System.currentTimeMillis();
		doMergesort(arr1);
		System.out.println("Time Taken : " + (System.currentTimeMillis() - start));
		display(arr1);
	}

	private static void display(int[] array) {

		
		System.out.println(Arrays.toString(array));
	}

	private static void doMergesort(int start, int end) {

		if (start < end) {
			int middle = start + (end - start) / 2;

			// divide
			doMergesort(start, middle);
			doMergesort(middle + 1, end);

			// merge
			mergeParts(start, middle, end);
		}
	}

	private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
//		System.out.println(lowerIndex + "," + middle + "," + higherIndex);
		int tempArray[] = new int[arr.length];
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempArray[i] = arr[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempArray[i] <= tempArray[j]) {
				arr[k] = tempArray[i];
				i++;
			} else {
				arr[k] = tempArray[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			arr[k] = tempArray[i];
			k++;
			i++;
		}
	}

	private static void doMergesort(int[] arr) {

		int length = arr.length;
		if (length <= 1) {
			return;
		}

		// divide
		int[] first = new int[length / 2];
		int[] second = new int[length - first.length];

		System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);

		// recursively merge
		doMergesort(first);
		doMergesort(second);

		// merge
		merge(first, second, arr);
	}

	private static void merge(int[] first, int[] second, int[] result) {

		int iFirst = 0;
		int iSecond = 0;

		int iMerged = 0;
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] <= second[iSecond]) {
				result[iMerged] = first[iFirst];
				iFirst++;
			} else {
				result[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}

		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}
}
