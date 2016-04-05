package com.prac.algos.string.problems;

import java.util.Scanner;

public class StringPermutation {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str = scanner.next();
		permute(str.toCharArray(), 0, str.length() - 1);
		System.out.println("Count is:" + count);
	}

	private static void permute(char[] str, int start, int end) {
		char t1, t2;
		if (start == end) {
			count++;
			System.out.println(str);
		}
		for (int i = start; i <= end; i++) {
			// swap();
			t1 = str[start];
			t2 = str[i];
			
			str[start] = t2;
			str[i] = t1;
			permute(str, start + 1, end);
			// swap();
			str[start] = t1;
			str[i] = t2;
		}
	}
}
