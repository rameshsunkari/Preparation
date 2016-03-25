package com.prac.ds.trees.binarytrees.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindNumOfLeaves {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		Node halfNodeRoot = new Node(1);
		halfNodeRoot.left = new Node(2);
		halfNodeRoot.right = new Node(3);
		halfNodeRoot.left.left = new Node(4);

		halfNodeRoot.right.left = new Node(6);
		halfNodeRoot.right.right = new Node(7);
		halfNodeRoot.right.right.left = new Node(8);
		halfNodeRoot.left.left.left = new Node(5);

		System.out.println("No of Leaves:" + findNumOfLeaves(root));
		System.out.println("No of Full Nodes:" + findNumOfFullNodes(root));
		System.out.println("No of Half Nodes:"
				+ findNumOfHalfNodes(halfNodeRoot));

	}

	private static int findNumOfHalfNodes(Node root) {
		// Level Order

		int count = 0;
		if (root != null) {
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp != null) {
					if ((tmp.left != null && tmp.right == null)
							|| (tmp.left == null && tmp.right != null)) {
						count++;
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

		return count;

	}

	private static int findNumOfLeaves(Node root) {
		// Level Order

		int count = 0;
		if (root != null) {
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp != null) {
					if (tmp.left == null && tmp.right == null) {
						count++;
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

		return count;

	}

	private static int findNumOfFullNodes(Node root) {
		// Level Order

		int count = 0;
		if (root != null) {
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp != null) {
					if (tmp.left != null && tmp.right != null) {
						count++;
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

		return count;

	}

}
