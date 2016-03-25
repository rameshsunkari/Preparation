package com.prac.ds.trees.binarytrees.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindMaxElement {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(91);
		root.left.right = new Node(6);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(7);
		root.left.right.left = new Node(11);
		root.left.left.right = new Node(10);
		System.out.println("Recursive:"+findMaxInBTRecursive(root));
		System.out.println("Iterative:"+findMaxInBTIterative(root));
	}

	private static int findMaxInBTIterative(Node root) {
		int max = Integer.MIN_VALUE;
		if (root != null) {
			Queue<Node> queue = new ArrayDeque<Node>();
			
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp != null) {
					if (tmp.data > max) {
						max = tmp.data;
					}
					if (tmp.left != null) {
						queue.offer(tmp.left);
					}
					if (tmp.right != null) {
						queue.offer(tmp.right);
					}
				}
			}
		}
		return max;
	}

	private static int findMaxInBTRecursive(Node root) {
		int max = Integer.MIN_VALUE;
		
		if (root != null) {
			
			int leftMax = findMaxInBTRecursive(root.left);
			int rightMax = findMaxInBTRecursive(root.right);
			
			max = Math.max(leftMax, rightMax);
			
			max = Math.max(root.data, max);
		}
		
		
		
		return max;
	}

}
