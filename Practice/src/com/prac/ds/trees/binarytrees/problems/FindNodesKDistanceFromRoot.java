package com.prac.ds.trees.binarytrees.problems;

public class FindNodesKDistanceFromRoot {
	
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
        root.right.right = new Node(18);
        root.left.right.left = new Node(181);
        root.left.right.right = new Node(183);
		
		int distance=2;
		findKDistance(root, distance);

	}

	private static void findKDistance(Node root, int distance) {
		if (root == null) {
			return ;
		}
		
		if (distance == 0) {
			System.out.println(root.data);
		}
		
		findKDistance(root.left, distance-1);
		findKDistance(root.right, distance-1);
		
	}

}
