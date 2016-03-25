package com.prac.ds.trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Sibling {

	public static void main(String[] args) {
		Node rootNode = null;

		rootNode = addNode(rootNode, 10, true);
		rootNode = addNode(rootNode, 5, true);
		rootNode = addNode(rootNode, 2, true);

		rootNode = addNode(rootNode, 30, true);
		rootNode = addNode(rootNode, 40, true);

		linkNodesAtSameLevelWithExtraSpace(rootNode);
		System.out.println(rootNode);
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

	private static Node addNode(Node rootNode, int i, boolean isRootNode) {
		if (rootNode == null) {
			return new Node(i);
		} else {
			if (i > rootNode.getData()) {
				if (isRootNode) {
					Node nodeToAdd = addNode(rootNode.getRight(), i, isRootNode);
					rootNode.setRight(nodeToAdd);
				} else {
					Node nodeToAdd = addNode(rootNode.getLeft(), i, isRootNode);
					rootNode.setLeft(nodeToAdd);
				}

			} else {
				if (isRootNode) {
					Node nodeToAdd = addNode(rootNode.getLeft(), i, isRootNode);
					rootNode.setLeft(nodeToAdd);
				} else {
					Node nodeToAdd = addNode(rootNode.getRight(), i, isRootNode);
					rootNode.setRight(nodeToAdd);
				}
			}
		}
		return rootNode;
	}
}
