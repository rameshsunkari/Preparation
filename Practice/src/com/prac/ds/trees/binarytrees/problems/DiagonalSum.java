package com.prac.ds.trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//Java Program to find diagonal sum in a Binary Node

public class DiagonalSum {

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
		diagonalSum(root);
	}

	public static void diagonalSum(Node root) {
		// Queue which stores tree nodes
		Queue<Node> queue = new LinkedList<Node>();

		// Map to store sum of node's data lying diagonally
		Map<Integer, Integer> map = new TreeMap<>();

		// Assign the root's vertical distance as 0.
		root.vd = 0;

		// Add root node to the queue
		queue.add(root);

		// Loop while the queue is not empty
		while (!queue.isEmpty()) {
			// Remove the front tree node from queue.
			Node curr = queue.remove();

			// Get the vertical distance of the dequeued node.
			int vd = curr.vd;

			// Sum over this node's right-child, right-of-right-child
			// and so on
			while (curr != null) {
				int prevSum = (map.get(vd) == null) ? 0 : map.get(vd);
				map.put(vd, prevSum + curr.data);

				// If for any node the left child is not null add
				// it to the queue for future processing.
				if (curr.left != null) {
					curr.left.vd = vd + 1;
					queue.add(curr.left);
				}

				// Move to the current node's right child.
				curr = curr.right;
			}
		}

		/*// Make an entry set from map.
		Set<Entry<Integer, Integer>> set = map.entrySet();

		// Make an iterator
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();

		// Traverse the map elements using the iterator.
		System.out.print("Diagonal sum in a binary tree is - ");
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();

			System.out.print(me.getValue() + " ");
		}*/
		System.out.print("Diagonal sum in a binary tree is - ");
		for (Integer node: map.keySet()) {
			System.out.println(map.get(node));
			
		}
	}
}
