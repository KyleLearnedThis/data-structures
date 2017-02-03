package com.albion.common.search.bst;

import com.albion.common.tree.node.BinarySearchTreeNode;

public class PostOrderTraversal<T extends Comparable<?>> implements Traversal {

	protected BinarySearchTreeNode<T> root;

	public PostOrderTraversal(BinarySearchTreeNode<T> aRoot){
		root = aRoot;
	}

	@Override
	public void traverse() {
		traverseWork(root);
	}

	public void traverseWork(BinarySearchTreeNode<T> node){
		if(node == null) {
			return;
		}
		traverseWork(node.getLeft());
		traverseWork(node.getRight());
		node.print(false);;
	}
}
