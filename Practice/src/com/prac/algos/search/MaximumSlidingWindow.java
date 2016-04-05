package com.prac.algos.search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSlidingWindow {

	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		int windowSize = 3;
		
		findMaxSlidingWindow(arr, windowSize);
	}

	private static void findMaxSlidingWindow(int[] arr, int windowSize) {

		int length = arr.length;
		int[] windowArray = new int[length];
		
		Deque<Integer> dequeue = new ArrayDeque<Integer>();
		for (int i =0; i < windowSize; i++) {
			while (!dequeue.isEmpty() && arr[i] >= arr[dequeue.peekLast()] ) {
				dequeue.pollLast();
			}
			
			dequeue.offerLast(i);
		}
		
		System.out.println(
				Arrays.toString(dequeue.toArray()));
		for (int i=windowSize; i < length; i++) {
			windowArray[i-windowSize] = arr[dequeue.peekFirst()];
			while (!dequeue.isEmpty() && arr[i] >= arr[dequeue.peekLast()] ) {
//				System.out.println("Removing Last:" + dequeue.peekLast());
				dequeue.pollLast();
			}
			
			while( !dequeue.isEmpty() && dequeue.peekFirst() <= i-windowSize) {
//				System.out.println("Removing First:" + dequeue.peekFirst());
				dequeue.pollFirst();
			}
			dequeue.offerLast(i);
		}
		windowArray[length-windowSize] = arr[dequeue.peekFirst()];
		
		System.out.println(Arrays.toString(windowArray));
	}

}
