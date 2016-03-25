package com.prac.alogos.searching.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSlidingWindow {
	
	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		System.out.println(Arrays.toString(arr));
		int k = 3;
		windowMax(arr, k);
	}

	// remove old element if still in que"

	/**
	 * Using a double ended Queue A.k.a - Deque in java A deque allows
	 * insertion/deletion on both ends. Maintain the first as the index of
	 * maximal of the window and elements after it are all smaller and came
	 * later than the first.
	 */
	public static void windowMax(int[] inBuffer, int window) {
		int w = (inBuffer.length < window) ? inBuffer.length : window;
		System.out.println("\n\n+ Window Size = " + w);

		Deque<Integer> que = new ArrayDeque<Integer>();

		// initialize window
		int i = 0;
		while (i < w) {
			while (!que.isEmpty() && inBuffer[i] >= inBuffer[que.getLast()]) {
				que.removeLast();
			}
			que.addLast(i++);
			/** just store the index of maximal element in the window */
		}

		System.out.println("+ After init = " + que.toString());

		// sliding window
		int[] max = new int[inBuffer.length - w + 1];
		max[i - w] = inBuffer[que.getFirst()];

		while (i < inBuffer.length) {
			// add new element
			while (!que.isEmpty() && inBuffer[que.getLast()] <= inBuffer[i]) {
				que.removeLast();
			}
			que.addLast(i);

			// remove old element if still in que
			if (!que.isEmpty() && i - w >= que.getFirst()) {
				que.removeFirst();
			}

			// get maximal
			++i;
			max[i - w] = inBuffer[que.getFirst()];
		}

		// return max;
		System.out.println("\n+ Max from sliding window: ");
		for (int j : max) {
			System.out.print(" " + j);
		}
	}

}
