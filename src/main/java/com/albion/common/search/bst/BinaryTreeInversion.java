package com.albion.common.search.bst;

import com.albion.common.tree.TreeNode;

public class BinaryTreeInversion {
	
	public TreeNode<Integer> root;
	
	public BinaryTreeInversion(TreeNode<Integer> root) {
		this.root = root;
	}
	
	public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
		if(root!=null){
			helper(root);
		}
		return root;    
	}

	public void helper(TreeNode<Integer> p){
		TreeNode<Integer> temp = p.left;
		p.left = p.right;
		p.right = temp;

		if(p.left!=null){
			helper(p.left);
		}
		if(p.right!=null){
			helper(p.right);
		}
	}
	
	public TreeNode<Integer> invert(){
		invertTree(this.root);
		return this.root;
	}
}
