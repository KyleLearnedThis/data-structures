package com.albion.common.tree;

import com.albion.common.tree.node.BinarySearchTreeNode;

public class BinarySearchTree<T extends Comparable<T>> {
	protected BinarySearchTreeNode<T> root;
	public BinarySearchTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinarySearchTreeNode<T> root) {
		this.root = root;
	}

	public BinarySearchTree(){
		root = null;
	}

	public BinarySearchTree(BinarySearchTreeNode<T> root) {
		this.root = root;
	}

	public void insert(T data){
		if (root == null) {
			root = new BinarySearchTreeNode<>(data, null, null, null);
		}else{
			internalInsert(root, data);
		}
	}

	private void internalInsert(BinarySearchTreeNode<T> node, T data){
		// Not the same value twice
		if(this.find(data) != null) {
			return;
		}

		T val = node.getValue();

		if (data == node.getValue()) {
			return;
		} else if (data.compareTo(val) == -1) {
			if (node.getLeft() == null) {
				node.setLeft(new BinarySearchTreeNode<>(data, node, null, null));
			} else {
				internalInsert(node.getLeft(), data);
			}
		} else {
			if (node.getRight() == null) {
				node.setRight(new BinarySearchTreeNode<>(data, node, null, null));
			} else {
				internalInsert(node.getRight(), data);
			}       
		}
	}

	public BinarySearchTreeNode<T> find(T seek){
		BinarySearchTreeNode<T> cur = root;

		while(cur!=null){
			if(seek.compareTo(cur.value) == 0){
				return cur;
			}
			else if(seek.compareTo(cur.value) == 1){
				cur = cur.getRight();
			}
			else{
				cur = cur.getLeft();
			}
		}

		return null;
	}

	public BinarySearchTreeNode<T> findParent(T val) {
		return findParent(val, root, null);
	}

	public BinarySearchTreeNode<T> findParent(T val, BinarySearchTreeNode<T> node, BinarySearchTreeNode<T> parent) {
		if (node == null) {
			return null;
		} else if (!node.getValue().equals(val)) {
			parent = findParent(val, node.getLeft(), node);
			if (parent == null) {
				parent = findParent(val, node.getRight(), node);
			}
		}
		return parent;
	}

	public boolean isValidBST(BinarySearchTreeNode<T> p, T min, T max) {
		if (p == null) {
			return true;
		}
		if (p.value.compareTo(min) <= 0 || p.value.compareTo(max) >= 0){
			return false;
		}
		return isValidBST(p.getLeft(), min, p.value) && isValidBST(p.getRight(), p.value, max);
	}

	public BinarySearchTreeNode<T> deleteNode(BinarySearchTreeNode<T> root, T key) {
		if(root == null){
			return null;
		}

		int val = key.compareTo(root.getValue());
		if(val == -1) {
			root.left = deleteNode(root.getLeft(), key);
		} else if( val == 1) {
			root.right = deleteNode(root.getRight(), key);
		} else {
			if(root.left == null){
				return root.getRight();
			}else if(root.right == null){
				return root.getLeft();
			}

			BinarySearchTreeNode<T> minNode = findMin(root.getRight());
			root.value = minNode.getValue();
			root.right = deleteNode(root.getRight(), root.getValue());
		}
		return root;
	}

	private BinarySearchTreeNode<T> findMin(BinarySearchTreeNode<T> node){
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}
}
