package com.prac.alogos.sort.problems;

import java.util.Arrays;

public class ZigZagSort {

	public static void main(String[] args) {
		int[] input = { 6,5,4,3,2,1};
		zigzag(input);
		System.out.println(Arrays.toString(input));
	}

	private static void zigzag(int[] input) {
		boolean swapLeftToRight = true;
		for (int i = 1; i < input.length; i++) {
			if (swapLeftToRight) {
				if (input[i] < input[i - 1]) {
					int temp = input[i];
					input[i] = input[i - 1];
					input[i - 1] = temp;
				}
			} else {
				if (input[i] > input[i - 1]) {
					int temp = input[i];
					input[i] = input[i - 1];
					input[i - 1] = temp;
				}
			}
			swapLeftToRight = !swapLeftToRight;
		}
	}

}
