package com.albion.common.search.bst;

import com.albion.common.tree.node.BinarySearchTreeNode;

public class InOrderTraversal<T extends Comparable<?>>  implements Traversal {

	protected BinarySearchTreeNode<T> root;
	
	public InOrderTraversal(BinarySearchTreeNode<T> x) {
		root = x;
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
		node.print(false);
		traverseWork(node.getRight());
	}
}
