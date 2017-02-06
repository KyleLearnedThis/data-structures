package com.albion.common.search.bst;

import com.albion.common.tree.node.BaseTreeNode;

public class PostOrderTraversal<T extends Comparable<?>> implements Traversal {

	protected BaseTreeNode<T> root;

	public PostOrderTraversal(BaseTreeNode<T> aRoot){
		root = aRoot;
	}

	@Override
	public void traverse() {
		traverseWork(root);
		System.out.println("");
	}

	public void traverseWork(BaseTreeNode<T> node){
		if(node == null) {
			return;
		}
		traverseWork(node.getLeft());
		traverseWork(node.getRight());
		node.print();
	}
}
