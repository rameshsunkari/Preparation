package com.prac.ds.trees.binarytrees.traversals;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {

	public static void main(String[] args) {

		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Iterative:");
        levelOrderIterative(root);
        System.out.println();
        System.out.println("Reverse:");
        levelOrderReverse(root);
        

	}

	private static void levelOrderIterative(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		
		if (root == null) {
			return;
		}
		
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if (tmp != null) {
				System.out.print(tmp.data + "->");
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			
		}
		
	}
	
	private static void levelOrderReverse(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		Stack<Node> stk = new Stack<Node>();
		
		if (root == null) {
			return;
		}
		
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if (tmp != null) {
//				System.out.print(tmp.data + "->");
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
				stk.push(tmp);
			}
		}
		
		while(!stk.isEmpty()) {
			System.out.print(stk.pop().data + "->");
		}
		
	}

}
