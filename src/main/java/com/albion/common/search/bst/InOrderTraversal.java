package com.albion.common.search.bst;

import com.albion.common.tree.node.BaseTreeNode;

public class InOrderTraversal<T extends Comparable<?>>  implements Traversal {

	protected BaseTreeNode<T> root;
	
	public InOrderTraversal(BaseTreeNode<T> x) {
		root = x;
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
		node.print();
		traverseWork(node.getRight());
	}
}
