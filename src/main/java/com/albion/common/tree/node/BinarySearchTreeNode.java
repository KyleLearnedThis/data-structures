package com.albion.common.tree.node;

public class BinarySearchTreeNode<T extends Comparable<?>> extends BaseTreeNode<T>{
	public BinarySearchTreeNode<T> parent;

	public BinarySearchTreeNode<T> getParent() {
		return parent;
	}
	public void setParent(BinarySearchTreeNode<T> parent) {
		this.parent = parent;
	}
	public BinarySearchTreeNode(T aValue, BinarySearchTreeNode<T> aParent, BinarySearchTreeNode<T> aLeft, BinarySearchTreeNode<T> aRight){
		super(aValue);
		parent = aParent;
		left = aLeft;
		right = aRight;
	}
	
	public BinarySearchTreeNode(T value) {
		super(value);
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

	@Override
	public BinarySearchTreeNode<T> getLeft() {
		BaseTreeNode<T> left = this.left;
		return (BinarySearchTreeNode<T>) left;
	}

	@Override
	public BinarySearchTreeNode<T> getRight() {
		BaseTreeNode<T> right = this.right;
		return (BinarySearchTreeNode<T>) right;
	}
}
