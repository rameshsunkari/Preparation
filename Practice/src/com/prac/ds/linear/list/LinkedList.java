package com.prac.ds.linear.list;

public class LinkedList<T> {

	private int length = 0;
	private LinkedNode<T> headNode;

	public LinkedList() {

	}

	public int getLength() {
		return this.length;
	}

	public LinkedNode<T> getHeadNode() {
		return headNode;
	}

	private void insert(T node, int position) {

	}

	public void insertAtStart(LinkedNode<T> node) {
		node.setNextNode(headNode);
		headNode = node;
		length++;
	}

	public void insertAtEnd(LinkedNode<T> node) {

		if (length == 0) {
			headNode = node;
		} else {
			LinkedNode<T> p, q;
			for (p = headNode; (q = p.getNextNode()) != null; p = q) {
				p.setNextNode(node);
			}
		}

		length++;
	}

	public void insertAtPoisition(LinkedNode<T> node, int position) {

		// invalid case
		if (position < 0) {
			return;
		}

		// if position > length insert at end
		if (position > length) {
			position = length;
		}

		if (length == 0) {
			headNode = node;
		} else if (position == 0) {
			LinkedNode<T> temp = node;
			temp.setNextNode(headNode);
			headNode = temp;
		} else {
			LinkedNode<T> current = headNode;
			for (int i = 1; i < position; i++) {
				current = current.getNextNode();
			}

			// set the current node
			node.setNextNode(current.getNextNode());
			// set the new node as current's next node
			current.setNextNode(node);
		}

		length++;
	}

	public LinkedNode<T> remove(int position) {
		LinkedNode<T> temp = null;

		return temp;

	}

	public LinkedNode<T> removeAtPosition(int position) {
		LinkedNode<T> temp = headNode;
		if (length == 0 || temp == null) {
			return temp;
		}

		if (position < 0) {
			position = 0;
		}

		if (position >= length) {
			position = length - 1;
		}

		if (position == 0) {
			headNode = temp.getNextNode();
			temp.setNextNode(null);
		} else {
			for (int i = 1; i < position; i++) {
				temp = temp.getNextNode();
			}

			temp.setNextNode(temp.getNextNode().getNextNode());
		}

		length--;
		return temp;
	}

	public LinkedNode<T> removeAtStart() {
		LinkedNode<T> temp = headNode;
		if (temp != null) {
			headNode = temp.getNextNode();
			temp.setNextNode(null);
			length--;
		}

		return temp;
	}

	public LinkedNode<T> removeAtEnd() {
		LinkedNode<T> temp = headNode;
		if (headNode != null) {
			LinkedNode<T> q = null, nextNode = temp.getNextNode();
			if (nextNode == null) {
				headNode = null;
			} else {
				while ((nextNode = temp.getNextNode()) != null) {
					q = temp;
					temp = nextNode;
				}
				q.setNextNode(null);
			}
		}

		length--;
		return temp;
	}

	public void removeMatched(LinkedNode<T> node) {

		if (headNode == null) {
			return;
		}

		if (headNode.equals(node)) {
			headNode = headNode.getNextNode();
			length--;
			return;
		}

		LinkedNode<T> p = headNode, q = null;
		while ((q = p.getNextNode()) != null) {
			if (node.equals(q)) {
				p.setNextNode(q.getNextNode());
				length--;
				return;
			}
			p = q;
		}

	}

	public int getPosition(LinkedNode<T> node) {
		int pos = 0;
		LinkedNode<T> temp = headNode;
		while (temp != null) {
			if (temp.equals(node)) {
				return pos;
			}
			pos++;
			temp = temp.getNextNode();
		}
		return Integer.MIN_VALUE;
	}

	public void clearList() {
		headNode = null;
		length = 0;

	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[result=");
		if (headNode == null) {
			str.append("]");
		}

		LinkedNode<T> temp = headNode;

		while (temp.getNextNode() != null) {
			str.append(temp.getData()).append(",");
			temp = temp.getNextNode();
		}

		str.append("]");

		return str.toString();
	}

}
