package com.albion.common.tree;

public class TreeNode<T extends Comparable<?>> {
	public TreeNode<T> parent;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T value;
	public TreeNode<T> getParent() {
		return parent;
	}
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	public TreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	public TreeNode<T> getRight() {
		return right;
	}
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public TreeNode(T aValue, TreeNode<T> aParent, TreeNode<T> aLeft, TreeNode<T> aRight){
		parent = aParent;
		left = aLeft;
		right = aRight;
		value = aValue;
	}
	
	public TreeNode(T value) {
		this.value = value;
	}
	
	public void print(boolean isVerbose){
		if(isVerbose) {
			String myParent, myLeft, myRight = "";
			myParent = parent==null?"-":parent.getValue().toString();
			myLeft = left==null?"-":left.getValue().toString();
			myRight = right==null?"-":right.getValue().toString();
			System.out.println("[ value: " + value + " parent: "+ myParent+" left: " + myLeft+ " right: " + myRight+ " ]");
		} else {
			System.out.print("[" + value + "] ");
		}
	}
	
	public void print() {
		print(false);
	}
	
    public TreeNode<T> minNode() {
        if (left == null)
              return this;
        else
              return left.minNode();
  }
}
