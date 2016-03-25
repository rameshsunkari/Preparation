package com.prac.ds.trees.binarytrees.problems;

public class FindLevelOfNode {
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
		
		int data=3;
		System.out.println("Level:"+findLevelOfNode(root, data, 0));

	}

	private static int findLevelOfNode(Node root, int data, int level) {
		if (root == null) {
			return 0;
		}
		
		if (root.data == data) {
			return level;
		}
		
		int leftLevel = findLevelOfNode(root.left, data, level+1);
		int rightLevel = findLevelOfNode(root.right, data, level+1);
		
		int clevel = leftLevel > rightLevel? leftLevel: rightLevel;
		
		
		return clevel;
	}

}
