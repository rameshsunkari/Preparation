package com.prac.ds.trees.binarytrees.problems;

import java.util.Stack;


public class FindHeight {

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
		System.out.println(findHeightRecursive(root));
		System.out.println(findHeightIterative(root));
//		System.out.println(findHeightPostOrder(root));
	}

	private static int findHeightRecursive(Node root) {
		// pre order traversal
		int height = 0;
		
		if (root != null) {
			int leftDepth = findHeightRecursive(root.left);
			int rightDepth = findHeightRecursive(root.right);
			height = Math.max(leftDepth , rightDepth) + 1;
		}

		return height;
	}
	
	/*private static int findHeightIterative(Node root) {
		// level order
		int height = 0;
		
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			
			queue.offer(root);
			queue.offer(null);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp != null) {
					if (tmp.left != null || tmp.right != null) {
						height++;
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

		return height;
	}*/
	
	private static int findHeightIterative(Node root) {
		int height = 0;
		if (root == null) {
			return height;
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
					stk.pop();
				}

			} 
			
			/* go up the tree from left node, if the child is right 
            push it onto stack otherwise process parent and pop stack */
			else if (current.left == previous) {
				if (current.right != null) {
					stk.push(current.right);
				} else {
					stk.pop();
				}
			} 
			/* go up the tree from right node and after coming back
            from right node process parent and pop stack */
			else if (current.right == previous) {
				stk.pop();
			}

			previous = current;
			if (stk.size() > height) {
				height = stk.size();
			}
		}
	return height;
	}

}
