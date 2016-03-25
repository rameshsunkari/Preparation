package com.prac.ds.trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;


public class FindMinHeight {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println(findMinHeightRecursive(root));
		System.out.println(findMinHeightIterative(root));
//		System.out.println(findHeightPostOrder(root));
	}

	private static int findMinHeightRecursive(Node root) {
		// pre order traversal
		int height = 0;
		
		if (root != null) {
			
			if (root.left == null && root.right == null) {
				return 1;
			} else if (root.left != null && root.right == null) {
				return 1+findMinHeightRecursive(root.left);
				
			} else if (root.right != null && root.left == null) {
				return 1+findMinHeightRecursive(root.right);
			} else {
				return Math.min(findMinHeightRecursive(root.left), findMinHeightRecursive(root.right))+1;
			}
		}

		return height;
	}
	
	private static int findMinHeightIterative(Node root) {
		// level order
		int height = 0;
		
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp != null) {
					if (tmp.left != null && tmp.right != null) {
						return height;
					}
					if (tmp.left != null) {
						queue.offer(tmp.left);
						height++;
					}
					if (tmp.right != null) {
						queue.offer(tmp.right);
						height++;
					}
				} else {
					if(!queue.isEmpty()) {
						height++;
					}
				}
			}
		}

		return height;
	}
	
	/*private static int findMinHeightIterative(Node root) {
		int height = 0;
		if (root == null) {
			return height;
		}

		Stack<Node> stk = new Stack<Node>();
		stk.push(root);
		Node previous = null;
		while (!stk.isEmpty()) {
			Node current = stk.peek();
			 go down the tree in search of a leaf an if so process it and pop
            stack otherwise move down 
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
			
			 go up the tree from left node, if the child is right 
            push it onto stack otherwise process parent and pop stack 
			else if (current.left == previous) {
				if (current.right != null) {
					stk.push(current.right);
				} else {
					stk.pop();
				}
			} 
			 go up the tree from right node and after coming back
            from right node process parent and pop stack 
			else if (current.right == previous) {
				stk.pop();
			}

			previous = current;
			if (stk.size() > height) {
				height = stk.size();
			}
		}
	return height;
	}*/

}
