package com.prac.ds.trees.binarytrees.problems;

class Node {
	int data;
	Node left;
	Node right;
	Node nextRight;
	int vd;

	public Node(int data) {
		this.data = data;
		vd = Integer.MAX_VALUE;
		left = right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getNextRight() {
		return nextRight;
	}

	public void setNextRight(Node nextRight) {
		this.nextRight = nextRight;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", nextRight=" + nextRight + "]";
	}
	
	
	
	
}