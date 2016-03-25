package com.prac.ds.trees.binarytrees.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindSize {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(9);
		root.left.right = new Node(6);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(7);
		root.left.right.left = new Node(11);
		root.left.left.right = new Node(10);
		System.out.println("Size Recursive:" + findSizeRecursive(root));
		System.out.println("Size Iterative:" + findSizeIterative(root));
	}

	private static int findSizeIterative(Node root) {
		int count = 0;
		if (root != null) {
			if (root != null) {
				Queue<Node> queue = new ArrayDeque<Node>();
				
				queue.offer(root);
				while (!queue.isEmpty()) {
					Node tmp = queue.poll();
					if (tmp != null) {
						count++;
						if (tmp.left != null) {
							queue.offer(tmp.left);
						}
						if (tmp.right != null) {
							queue.offer(tmp.right);
						}
					}
				}
			}

		}
		return count;
	}

	private static int findSizeRecursive(Node root) {
		int count = 0;
		if (root != null) {
			/*int leftCount = root.left != null ? findSizeIterative(root.left) : 0;
			int rightCount = root.right != null ?findSizeIterative(root.right):0;*/
			int leftCount = findSizeIterative(root.left);
			int rightCount = findSizeIterative(root.right);
			count = leftCount + rightCount + 1;
		}
		return count;
	}
}
