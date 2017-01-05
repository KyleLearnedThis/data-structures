package com.albion.common.search.bst;

import com.albion.common.tree.TreeNode;


public class BinaryTreeInversion<T extends Comparable<?>> {
	public TreeNode<T> root;

	public BinaryTreeInversion(TreeNode<T> root) {
		this.root = root;
	}

	public TreeNode<T> invertTree(TreeNode<T> root) {
		if (root != null) {
			helper(root);
		}
		return root;
	}

	public void helper(TreeNode<T> p) {
		TreeNode<T> temp = p.left;
		p.left = p.right;
		p.right = temp;

		if (p.left != null) {
			helper(p.left);
		}
		if (p.right != null) {
			helper(p.right);
		}
	}

	public TreeNode<T> invert() {
		invertTree(this.root);
		return this.root;
	}
}