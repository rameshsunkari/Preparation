package com.prac.ds.trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Sibling {
	

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		linkNodesAtSameLevelWithExtraSpace(root);
		
		System.out.println(root);
		System.out.println(root.left);
	}
	
	private static void linkNodesAtSameLevelWithExtraSpace(Node rootNode) {
		if (rootNode == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode); // Adding Level 1 in Queue
		queue.add(null);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node != null) {
				node.setNextRight(queue.peek()); // setting nextRight to head of
													// Queue.

				if (node.getLeft() != null) // adding entries in Queue for Next
											// Level
					queue.add(node.getLeft());

				if (node.getRight() != null) // adding entries in Queue for Next
												// Level
					queue.add(node.getRight());

			} else {

				// checking if queue head is null, if it is null then this is
				// end of all levels
				// and if queue head is not null then this is end of level and
				// adding null to indicate end of level.
				if (queue.peek() != null)
					queue.add(null);

			}
		}
	}

}
