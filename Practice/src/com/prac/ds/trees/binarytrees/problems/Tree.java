package com.prac.ds.trees.binarytrees.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

	public Node rootNode;
	private ArrayList<Integer> listOfNodes = new ArrayList<Integer>();

	public Tree(Node rootNode) {
		this.rootNode = rootNode;
	}

	public Tree() {
		this.rootNode = null;
	}

	public void addNode(Node node) {

		// Nodes present, So check the proper position where to add New
		// Node.

		// Checking whether Left child and Right child are present for root
		// Node.
		if (rootNode.getLeft() != null && rootNode.getRight() != null) {
			// Left and Right Child exist, Also, we need to add new Node in
			// Sequential Fashion of Left and Right,
			// We have to scan all Levels one by one to check a proper place
			// for new Node.
			// Also, we for each and every node we need to check whether
			// Left and Right Exist,
			// So we need to store them for later Processing that is why we
			// introduced Queue.

			Queue<Node> queue = new LinkedList<Node>();
			queue.add(node);

			while (!queue.isEmpty()) {
				Node obj = (Node) queue.poll();
				if (obj.getLeft() != null && obj.getRight() != null) {
					queue.add(obj.getLeft());
					queue.add(obj.getRight());
				} else if (obj.getLeft() == null) {
					obj.setLeft(node);
					break;
				} else {
					obj.setRight(node);
					break;
				}
			}

		} else {
			// We reach this condition when either Left or Right is Null,
			// but not sure which side is Null.
			if (rootNode.getLeft() == null) {
				rootNode.setLeft(node);
			} else {
				rootNode.setRight(node);
			}
		}

	}

	public void addNode(int data) {

		// First check is there any Nodes present.
		if (this.rootNode == null) {
			// No Nodes are Present, create one and assign it to startNode
			Node temp1 = new Node(data);
			this.rootNode = temp1;
		} else {

			Node node = new Node(data);
			// Nodes present, So check the proper position where to add New
			// Node.

			// Checking whether Left child and Right child are present for root
			// Node.
			if (rootNode.getLeft() != null && rootNode.getRight() != null) {
				// Left and Right Child exist, Also, we need to add new Node in
				// Sequential Fashion of Left and Right,
				// We have to scan all Levels one by one to check a proper place
				// for new Node.
				// Also, we for each and every node we need to check whether
				// Left and Right Exist,
				// So we need to store them for later Processing that is why we
				// introduced Queue.

				Queue<Node> queue = new LinkedList<Node>();
				queue.add(rootNode);

				while (!queue.isEmpty()) {
					Node obj = (Node) queue.poll();
					if (obj.getLeft() != null && obj.getRight() != null) {
						queue.add(obj.getLeft());
						queue.add(obj.getRight());
					} else if (obj.getLeft() == null) {
						Node temp1 = new Node(data);
						obj.setLeft(temp1);
						break;
					} else {
						Node temp1 = new Node(data);
						obj.setRight(temp1);
						break;
					}
				}

			} else {
				// We reach this condition when either Left or Right is Null,
				// but not sure which side is Null.
				if (rootNode.getLeft() == null) {
					Node temp1 = new Node(data);
					rootNode.setLeft(temp1);
				} else {
					Node temp1 = new Node(data);
					rootNode.setRight(temp1);
				}
			}
		}
	}

	public Node findDeepestNode() {

		Node deepestNode = null;
		if (this.rootNode != null) {

			Queue<Node> queue = new ArrayDeque<Node>();

			queue.offer(this.rootNode);
			while (!queue.isEmpty()) {
				deepestNode = queue.poll();
				if (deepestNode.left != null) {
					queue.offer(deepestNode.left);
				}

				if (deepestNode.right != null) {
					queue.offer(deepestNode.right);
				}
			}

		}

		return deepestNode;
	}

	public Node findNode(int data) {

		Node found = null;

		if (this.rootNode != null) {
			Queue<Node> queue = new ArrayDeque<Node>();

			queue.offer(rootNode);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp != null) {
					if (tmp.data == data) {
						found = tmp;
						return found;
					}
					if (tmp.left != null) {
						queue.offer(tmp.left);
					}
					if (tmp.right != null) {
						queue.offer(tmp.right);
					}
				}
			}
		}
		return found;

	}

	public Node deleteNode(int data) {
		Node deepestNode = null;

		if (rootNode != null) {
			
			Node deletedNode = findNode(data);
			deepestNode = findDeepestNode();
			swap(deepestNode, deletedNode);
			deepestNode = null;
		}

		return deepestNode;
	}

	private void swap(Node node1, Node node2) {
		
		int temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
		
	}
	
	private void preOrderRecursive(Node root) {

		if (root == null) {
			return;
		}

		listOfNodes.add(root.data);
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);

	}

	@Override
	public String toString() {
		preOrderRecursive(rootNode);
		return "Tree [listOfNodes=" + listOfNodes + "]";
	}
	
	public void deleteTree() {
//		deleteNode(rootNode);
		rootNode = null;
	}
	
	public Node deleteNode(Node node) {
		if (node == null) {
			return null;
		}
		
		node.left = deleteNode(node.left);
		node.right = deleteNode(node.right);
		node = null;
		return node;
	}
	
	

}
