package com.albion.common.search.bst;

import com.albion.common.tree.TreeNode;

public class InOrderTraversal<T extends Comparable<?>>  implements Traversal {

	protected TreeNode<T> root;
	
	public InOrderTraversal(TreeNode<T> x) {
		root = x;
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
		node.print(false);
		traverseWork(node.getRight());
	}
}
