package com.prac.ds.linear.list;

public class DoubleLinkedNode<T> {

	private T data;
	private DoubleLinkedNode<T> rightNode;
	private DoubleLinkedNode<T> leftNode;

	public DoubleLinkedNode() {

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoubleLinkedNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(DoubleLinkedNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public DoubleLinkedNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(DoubleLinkedNode<T> rightNode) {
		this.rightNode = rightNode;
	}
}
