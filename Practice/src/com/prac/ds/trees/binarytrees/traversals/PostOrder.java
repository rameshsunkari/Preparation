package com.prac.ds.trees.binarytrees.traversals;

import java.util.Stack;



public class PostOrder {
	
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Recursive:");
        postOrderRecursive(root);
        System.out.println();
        System.out.println("Iterative:");
        postOrderIterative(root);
	}

	private static void postOrderIterative(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stk = new Stack<Node>();
		stk.push(root);
		Node previous = null;
		while (!stk.isEmpty()) {
			Node current = stk.peek();
			/* go down the tree in search of a leaf an if so process it and pop
            stack otherwise move down */
			if (previous == null || previous.left == current
					|| previous.right == current) {
				if (current.left != null) {
					stk.push(current.left);
				}

				else if (current.right != null) {
					stk.push(current.right);
				} else {
					System.out.print(current.data + "->");
					stk.pop();
				}

			} 
			
			/* go up the tree from left node, if the child is right 
            push it onto stack otherwise process parent and pop stack */
			else if (current.left == previous) {
				if (current.right != null) {
					stk.push(current.right);
				} else {
					System.out.print(current.data + "->");
					stk.pop();
				}
			} 
			/* go up the tree from right node and after coming back
            from right node process parent and pop stack */
			else if (current.right == previous) {
				System.out.print(current.data + "->");
				stk.pop();
			}

			previous = current;
		}
	}

	private static void postOrderRecursive(Node root) {
		
		if (root == null) {
			return;
		}
		
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		
		System.out.print(root.data + "->");
	}

}
