package com.prac.ds.trees.binarytrees.problems;

import java.util.Arrays;

public class PrintPathsWithKSum {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
		
		int sum=14;
		int[] printArray = new int[10];
		if (printPathWithKSum(root, sum, printArray, 0)){
			System.out.println("Has Match");
		}
	}

	private static boolean printPathWithKSum(Node root, int sum,int[] printArray, int level) {
		
		if (root == null) {
			return (sum == 0);
		}
		
		int subSum = sum - root.getData();
		printArray[level] = root.data;
		if (subSum == 0 && root.left == null && root.right == null) {
			System.out.println(Arrays.toString(printArray));
			return true;
		}
		
		boolean found = false;
		if (root.left != null) {
			found = found || printPathWithKSum(root.left, subSum, printArray, level+1);
		}
		
		if (root.right != null) {
			found = found || printPathWithKSum(root.right, subSum, printArray, level+1);
		}
		
		return found;
	}

}
