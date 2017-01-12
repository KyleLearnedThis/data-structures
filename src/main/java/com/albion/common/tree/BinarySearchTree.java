package com.albion.common.tree;

public class BinarySearchTree<T extends Comparable<T>> {
	protected TreeNode<T> root;
	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	public BinarySearchTree(){
		root = null;
	}

	public BinarySearchTree(TreeNode<T> root) {
		this.root = root;
	}

	public void insert(T data){
		if (root == null) {
			root = new TreeNode<T>(data, null, null, null);
		}else{
			internalInsert(root, data);
		}
	}

	private void internalInsert(TreeNode<T> node, T data){
		// Not the same value twice
		if(this.find(data) != null) {
			return;
		}

		T val = node.getValue();

		if (data == node.getValue()) {
			return;
		} else if (data.compareTo(val) == -1) {
			if (node.getLeft() == null) {
				node.setLeft(new TreeNode<>(data, node, null, null));
			} else {
				internalInsert(node.getLeft(), data);
			}
		} else {
			if (node.getRight() == null) {
				node.setRight(new TreeNode<>(data, node, null, null));
			} else {
				internalInsert(node.getRight(), data);
			}       
		}
	}

	public TreeNode<T> find(T seek){
		TreeNode<T> cur = root;

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


	public TreeNode<T> findParent(T val) {
		return findParent(val, root, null);
	}

	public TreeNode<T> findParent(T val, TreeNode<T> node, TreeNode<T> parent) {
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

	//TODO: assume no parent member existed
	public void delete(T value){
		TreeNode<T> node = this.find(value);
		if(node == null) {
			return;
		}
		TreeNode<T> parent = this.findParent(value);
		TreeNode<T> temp;

		if(node.getLeft() == null && node.getRight() == null){
			parent = null;
		}
		else if(node.getLeft() == null || node.getRight() == null){
			parent = node.getParent();
			if(node.getLeft() == null){
				temp = node.getRight();
				parent.setLeft(temp);
			}
			else{
				temp = node.getLeft();
				parent.setRight(temp);
			}
		}
		else{
			//Lazy, replace value only
			temp = node.getRight().minNode();
			System.out.println("WHO WHO 1:" + temp.getValue().toString());
			
			TreeNode<T> tempParent = temp.getParent();
			System.out.println("WHO WHO 2:" + tempParent.getValue().toString());
		}
	}


	public boolean isValidBST(TreeNode<T> p, T min, T max) {
		if (p == null) {
			return true;
		}
		if (p.value.compareTo(min) <= 0 || p.value.compareTo(max) >= 0){
			return false;
		}
		return isValidBST(p.left, min, p.value) && isValidBST(p.right, p.value, max);
	}

}
