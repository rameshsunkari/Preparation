package com.prac.ds.trees.binarytrees.problems;

public class CheckIdentity {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(3);
		tree.addNode(4);
		tree.addNode(5);
		tree.addNode(6);
		tree.addNode(7);

		Tree tree1 = new Tree();
		tree1.addNode(7);
		tree1.addNode(6);
		tree1.addNode(5);
		tree1.addNode(4);
		tree1.addNode(3);
		tree1.addNode(2);
		tree1.addNode(1);
//		tree1.addNode(10);

		if (checkStructuralIdentity(tree.rootNode, tree1.rootNode)) {
			System.out.println("both are identical");
		} else {
			System.out.println("Both are not identical");
		}

	}

	private static boolean checkStructuralIdentity(Node rootNode1,
			Node rootNode2) {
		if (rootNode1 == null && rootNode2 == null) {
			return true;
		}
		
		if (rootNode1 == null || rootNode2==null) {
			return false;
		}
		
		return checkStructuralIdentity(rootNode1.left, rootNode2.left) && checkStructuralIdentity(rootNode1.right, rootNode2.right); 

	}

}
