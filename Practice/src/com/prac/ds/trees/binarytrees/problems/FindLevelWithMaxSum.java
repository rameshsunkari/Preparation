package com.prac.ds.trees.binarytrees.problems;

import java.util.HashMap;
import java.util.Map;

public class FindLevelWithMaxSum {

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

		Map<Integer, Integer> levelSumMap = new HashMap<Integer, Integer>();
		levelSumMap.put(0, 0);
		maxSumAtAnyLevel(root, levelSumMap, 0);

		int max = 0;
		int maxLevel = 0;
		for (int key : levelSumMap.keySet()) {
			if (max < levelSumMap.get(key)) {
				max = levelSumMap.get(key);
				maxLevel = key;
			}
		}

		System.out.println("Max Sum at " + maxLevel + " level:" + max);

	}

	private static void maxSumAtAnyLevel(Node root,
			Map<Integer, Integer> levelSumMap, int level) {
		if (root != null) {
			if (levelSumMap.get(level) != null) {
				levelSumMap.put(level, levelSumMap.get(level) + root.data);
			} else {
				levelSumMap.put(level, root.data);
			}

			maxSumAtAnyLevel(root.left, levelSumMap, level + 1);
			maxSumAtAnyLevel(root.right, levelSumMap, level + 1);

		}

	}

}
