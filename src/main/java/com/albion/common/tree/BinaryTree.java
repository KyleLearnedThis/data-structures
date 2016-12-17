package com.albion.common.tree;

public class BinaryTree {
	protected TreeNode<Integer> root;
	public TreeNode<Integer> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<Integer> root) {
		this.root = root;
	}

	public BinaryTree(){
		root = null;
	}

	public void insert(Integer data){
		if (root == null) {
			root = new TreeNode<Integer>(data, null, null, null);    
		}else{
			internalInsert(root, data);
		}
	}

	private static void internalInsert(TreeNode<Integer> node, int data){
		// Not the same value twice
		if (data == node.getValue()) {
			return;
		} else if (data < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(new TreeNode<Integer>(data, node, null, null));
			}else{
				internalInsert(node.getLeft(), data);
			}
		}else{
			if (node.getRight() == null) {
				node.setRight(new TreeNode<Integer>(data, node, null, null));
			}else{
				internalInsert(node.getRight(), data);
			}       
		}
	}

//	public void traverse(){
//		traverseTreeInOrder(root);
//	}
//
//	public void traverseTreeInOrder(TreeNode<Integer> node) {
//		//incoming node is root
//		Stack< TreeNode<Integer> > nodes = new Stack<TreeNode<Integer> >();
//		while (!nodes.isEmpty() || null != node) {
//			if (null != node) {
//				nodes.push(node);
//				node = node.getLeft();
//			} else {
//				node = nodes.pop();
//				//	            System.out.println("V="+node.getValue()+ " P="+);
//				node.print(false);
//
//				node = node.getRight();
//			}
//		}                           
//	}

	public TreeNode<Integer> find(Integer seek){

		TreeNode<Integer> cur = root;

		while(cur!=null){
			if(seek.intValue() == cur.getValue().intValue()){
				return cur;
			}
			else if( seek.intValue() > cur.getValue().intValue()){
				cur = cur.getRight();
			}
			else{
				cur = cur.getLeft();
			}
		}

		return null;
	}

	public void delete(Integer value){
		TreeNode<Integer> node = this.find(value);
		if(node == null)
			return;
		
		TreeNode<Integer> temp, parent = null;
		if(node.getLeft() == null && node.getRight() == null){
			node = null;
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
			
			TreeNode<Integer> tempParent = temp.getParent();
			System.out.println("WHO WHO 2:" + tempParent.getValue().toString());
			

			
//			
//			
//			
//			//break temp parent child link
//			if(tempParent.getValue() > temp.getValue())
//				tempParent.setLeft(null);
//			else		
//				tempParent.setRight(null);
//			node.setValue(temp.getValue());
			
//			temp.setParent(null);


		}
	}



}
