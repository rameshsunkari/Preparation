package com.prac.algos.arrays.problems;

import java.util.Scanner;

public class PascalTriangle {
	public static void print(int n) {
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}

			for (int k = 0; k <= i; k++) {
				System.out.print(pascal(i, k) + " ");
			}
			System.out.println();
		}
	}

	public static int pascal(int i, int j) {
		if (j == 0 || j == i) {
			return 1;
		} else {
			return pascal(i - 1, j - 1) + pascal(i - 1, j);
		}

	}

	public static void pascalUsingDp(int n) {
		int[][] arr = new int[n][n];

		// Iterate through every line and print integer(s) in it
		for (int line = 0; line < n; line++) {
			// Every line has number of integers equal to line number
			for (int i = 0; i <= line; i++) {
				// First and last values in every row are 1
				if (line == i || i == 0)
					arr[line][i] = 1;
				else
					// Other values are sum of values just above and left of
					// above
					arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
			}
		}

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}

			for (int k = 0; k <= i; k++) {
				System.out.print(arr[i][k] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out
				.print("Enter the row number upto which Pascal's triangle has to be printed: ");
		int row = scanner.nextInt();
		// print(row);
		pascalUsingDp(row);
		/*
		 * int rows = 10;
		 * 
		 * 
		 * for(int i =0;i<rows;i++) { int number = 1;
		 * System.out.format("%"+(rows-i)*2+"s",""); for(int j=0;j<=i;j++) {
		 * System.out.format("%4d",number); number = number * (i - j) / (j + 1);
		 * 
		 * } System.out.println(); }
		 */
	}
}
