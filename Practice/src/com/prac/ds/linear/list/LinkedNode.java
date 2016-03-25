package com.prac.ds.linear.list;

public class LinkedNode<T> {

	private T data;
	private LinkedNode<T> nextNode;

	public LinkedNode() {

	}

	public LinkedNode(T data, LinkedNode<T> nextNode) {
		super();
		this.data = data;
		this.nextNode = nextNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkedNode<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	@Override
	public String toString() {
		return (String) data;
	}

}
