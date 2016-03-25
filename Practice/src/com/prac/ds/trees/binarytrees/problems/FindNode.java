package com.prac.ds.trees.binarytrees.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindNode {

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
		int k = 9;
		if (findNodeRecursive(root, k)) {
			System.out.println("Found the element:" + k);
		} else {
			System.out.println("Not Found the element:" + k);
		}
		
		if (findNodeIterative(root, k)) {
			System.out.println("Found the element:" + k);
		} else {
			System.out.println("Not Found the element:" + k);
		}
	}

	private static boolean findNodeIterative(Node root, int k) {
		boolean found = false;
		
		if (root != null) {
			Queue<Node> queue = new ArrayDeque<Node>();
			
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp != null) {
					if (tmp.data == k) {
						found = true;
						return found;
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
		return found;
	}

	private static boolean findNodeRecursive(Node root, int k) {
		boolean found = false;
		if (root != null) {
			if (root.data == k) {
				found = true;
			} else {
				found = findNodeRecursive(root.left, k);
				found = found || findNodeRecursive(root.right, k);
			}
		}
		
		return found;
	}

}
