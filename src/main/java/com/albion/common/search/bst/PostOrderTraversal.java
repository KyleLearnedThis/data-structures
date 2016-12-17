package com.albion.common.search.bst;

import com.albion.common.tree.TreeNode;

public class PostOrderTraversal<T extends Comparable<?>> implements Traversal  {

	protected TreeNode<T> root;

	public PostOrderTraversal(TreeNode<T> aRoot){
		root = aRoot;
	}

	@Override
	public void traverse() {
		traverseWork(root);
	}

	public void traverseWork(TreeNode<T> node){
		if(node == null) {
			return;
		}
		traverseWork(node.getLeft());
		traverseWork(node.getRight());
		node.print(false);;
	}
}
