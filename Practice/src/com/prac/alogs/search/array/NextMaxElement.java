package com.prac.alogs.search.array;

import java.util.Arrays;
import java.util.Stack;

public class NextMaxElement {

	public static void main(String[] args) {
//		int arr[] = { 11, 13, 21, 3 };
//		int arr[] = { 5,4,3,2,1};
		int arr[] = { 4,5,2,25};
		System.out.println(Arrays.toString(arr));
		prepareNextMaxArray(arr);
	}

	private static void prepareNextMaxArray(int[] a) {
		int m[] = new int[a.length];
		int count = 0;
		Stack<Integer> s = new Stack<Integer>();
		s.push(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (s.peek() != null) {
				while (true) {
					if (s.isEmpty() || s.peek() > a[i]) {
						break;
					}
					// which means the current element is greater than stack top, so empty the stack till it becomes empty.
					if (!s.isEmpty()) {
//						System.out.println(s.peek() + ":" + a[i]);
						s.pop();
						m[count++] = a[i];
					}
				}
			}
			s.push(a[i]);
		}
		System.out.println(count);
		while (!s.isEmpty() && s.peek() != null) {
			s.pop();
			m[count++] = -1;
		}
		System.out.println(Arrays.toString(m));
	}

}
