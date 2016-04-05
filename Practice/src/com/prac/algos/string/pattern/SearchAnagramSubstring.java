package com.prac.algos.string.pattern;

import java.util.ArrayList;
import java.util.List;

public class SearchAnagramSubstring {

	public static List<Integer> match(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		int[] count = new int[256];
		int[] tc = new int[256];
		for (int i = 0; i < p.length(); i++) {
			count[p.charAt(i)]++;
			tc[s.charAt(i)]++;
		}
		if (matchCount(count, tc))
			list.add(0);
		for (int i = p.length(); i < s.length(); i++) {
			tc[s.charAt(i - p.length())]--;
			tc[s.charAt(i)]++;
			if (matchCount(count, tc))
				list.add(i - p.length() + 1);
		}
		for (int num : list)
			System.out.print(num + " ");
		return list;
	}

	private static boolean matchCount(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		return true;
	}

	public static void main(String[] args) {
		match("ramesh", "em");
	}
}