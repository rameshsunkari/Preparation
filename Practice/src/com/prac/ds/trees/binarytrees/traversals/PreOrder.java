package com.prac.ds.trees.binarytrees.traversals;

import java.util.Stack;

public class PreOrder {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("Recursive:");
		preOrderRecursive(root);
		System.out.println();
		System.out.println("Iterative:");
		preOrderIterative(root);
	}

	private static void preOrderIterative(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stk = new Stack<Node>();
		stk.push(root);
		while (!stk.isEmpty()) {
			Node current = stk.pop();
			if (current != null) {
				System.out.print(current.data + "->");
				if (current.right != null) {
					stk.push(current.right);
				}
				if (current.left != null) {
					stk.push(current.left);
				}
				
			}
		}
	}

	private static void preOrderRecursive(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data + "->");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);

	}

}
