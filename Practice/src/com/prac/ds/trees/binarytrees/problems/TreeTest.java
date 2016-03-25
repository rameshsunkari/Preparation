package com.prac.ds.trees.binarytrees.problems;

import com.prac.ds.trees.binarytrees.traversals.InOrder;
import com.prac.ds.trees.binarytrees.traversals.LevelOrder;
import com.prac.ds.trees.binarytrees.traversals.PostOrder;
import com.prac.ds.trees.binarytrees.traversals.PreOrder;

public class TreeTest {

	public static void main(String[] args) {

		
		Tree tree = new Tree();
		tree.addNode(1);
		tree.addNode( 2);
		tree.addNode( 3);
		tree.addNode( 4);
		tree.addNode( 5);
		tree.addNode( 6);
		tree.addNode( 7);
		
		System.out.println(tree);
		System.out.println("Depest Node: " + tree.findDeepestNode().data);
		System.out.println("Find Node:" + tree.findNode(1).left.data);
		
		Tree tree1 = new Tree();
		tree1.addNode(1);
		tree1.addNode(2);
		tree1.addNode(3);
		System.out.println("Depest Node: " + tree1.findDeepestNode().data);
		/*tree1.deleteNode(tree1.findDeepestNode());
		System.out.println(tree1);*/
		
		tree1.deleteNode(1);
		System.out.println(tree1);
		
		/*tree1.deleteTree();
		System.out.println(tree1);*/
		
	}

}
