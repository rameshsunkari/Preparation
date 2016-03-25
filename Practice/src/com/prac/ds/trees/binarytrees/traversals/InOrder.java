package com.prac.ds.trees.binarytrees.traversals;

import java.util.Stack;



public class InOrder {
	
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Recursive:");
        InOrderRecursive(root);
        System.out.println();
        System.out.println("Iterative:");
        InOrderIterative(root);
	}

	private static void InOrderIterative(Node root) {
		
		Stack<Node> stk = new Stack<Node>();
		Node currentNode = root;
		boolean done = false;
		while(!done) {
			if (currentNode!=null) {
				stk.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if (stk.isEmpty()) {
					done = true;
					return;
				}
				currentNode = stk.pop();
				System.out.print(currentNode.data + "->");
				currentNode = currentNode.right;
			}
		}
	}

	private static void InOrderRecursive(Node root) {
		
		if (root == null) {
			return;
		}
		
		InOrderRecursive(root.left);
		System.out.print(root.data + "->");
		InOrderRecursive(root.right);
		
	}

}
