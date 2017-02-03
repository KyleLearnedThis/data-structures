package com.albion.common.search.bst;

import com.albion.common.tree.node.BinarySearchTreeNode;


public class BinaryTreeInversion<T extends Comparable<?>> {
	public BinarySearchTreeNode<T> root;

	public BinaryTreeInversion(BinarySearchTreeNode<T> root) {
		this.root = root;
	}

	public BinarySearchTreeNode<T> invertTree(BinarySearchTreeNode<T> root) {
		if (root != null) {
			helper(root);
		}
		return root;
	}

	public void helper(BinarySearchTreeNode<T> p) {
		BinarySearchTreeNode<T> temp = p.getLeft();
		p.left = p.right;
		p.right = temp;

		if (p.left != null) {
			helper(p.getLeft());
		}
		if (p.right != null) {
			helper(p.getRight());
		}
	}

	public BinarySearchTreeNode<T> invert() {
		invertTree(this.root);
		return this.root;
	}
}