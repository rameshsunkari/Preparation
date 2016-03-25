package com.prac.ds.trees.binarytrees.problems;

public class WidhtHeight {

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
		root.left.right.left.left = new Node(21);
		root.left.left.right = new Node(10);
		root.right.right.left = new Node(15);
		
		System.out.println("Max Depth(nodes at a level:" + width(root));
		System.out.println("Max Height(nodes from root to leaves:" + height(root));
		System.out.println("Diameter of Tree:" + diameter(root));

	}

	private static int diameter(Node root) {
		int diameter = 0;
		if (root != null) {
			int len1 = height(root.left) + height(root.right)+1;
			int len2 = Math.max(diameter(root.left), diameter(root.right));
			
			return Math.max(len1, len2);
		}
		return diameter;
	}

	private static int height(Node root) {
		int height = 0;
		if (root != null) {
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			
			height = Math.max(leftHeight, rightHeight)+1;
			
		}
		
		return height;
	}

	private static int width(Node root) {
		int max = 0;
		if (root != null) {
			
			int maxHeight = height(root);
			for (int i=0; i<maxHeight; i++) {
				int tmp = maxDepthAtLevel(root, i);
				max = Math.max(tmp, max);
			}
		}
		return max;
	}

	private static int maxDepthAtLevel(Node root, int level) {
		int maxDepth = 0;
		if (root != null) {
			if (level == 0) {
				maxDepth = 1;
			} else {
				return maxDepthAtLevel(root.left, level-1) + maxDepthAtLevel(root.right, level-1);
			}
		}
		return maxDepth;
	}
	
	

}
