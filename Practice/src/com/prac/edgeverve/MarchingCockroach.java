package com.prac.edgeverve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * http://mayankamukherjee.blogspot.in/2016/01/blog-post.html
 * @author KH1807
 *
 */
public class MarchingCockroach {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totallength = sc.nextInt();
		int totalants = sc.nextInt();
		if (totalants < 0 || totallength < 0) {
			return;
		}
		List<Integer> position = new ArrayList<Integer>();
		for (int i = 0; i < totalants; i++) {
			position.add(sc.nextInt());
		}

		int mintime = Integer.MIN_VALUE;
		for (int i = 0; i < totalants; i++) {
			int value = Math.min(position.get(i), totallength - position.get(i));
			if (value > mintime) {
				mintime = value;
			}
		}
		System.out.print(mintime + " ");

		int maxtime = Integer.MIN_VALUE;
		for (int i = 0; i < totalants; i++) {
			int max = Math.max(position.get(i), totallength - position.get(i));
			if (max > maxtime) {
				maxtime = max;
			}
		}
		System.out.print(maxtime + " ");
		sc.close();
	}
}
