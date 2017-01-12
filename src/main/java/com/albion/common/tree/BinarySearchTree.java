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

	public TreeNode<T> inOrderSuccessor(TreeNode start, TreeNode p) {
		if(start==null)
			return null;

		TreeNode next = null;
		TreeNode c = start;

		while(c!=null && c.getValue() != p.getValue()){
			if(c.getValue().compareTo(p.getValue()) == 1){
				next = c;
				c = c.getLeft();
			}else{
				c= c.getRight();
			}
		}

		if(c==null) {
			return null;
		}
		if(c.right==null) {
			return next;
		}
		c = c.right;
		while(c.left!=null) {
			c = c.left;
		}
		return c;
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

//	public BinaryNode findMin( BinaryNode t )
	public  TreeNode<T> findMin(TreeNode<T> start) {
		if( start == null )
			return null;
		else if( start.left == null )
			return start;
		return findMin( start.left );
	}

//	private BinaryNode remove( Comparable x, BinaryNode t )
//	{
//		if( t == null )
//			return t;   // Item not found; do nothing
//		if( x.compareTo( t.getValue() ) < 0 )
//			t.left = remove( x, t.left );
//		else if( x.compareTo( t.getValue() ) > 0 )
//			t.right = remove( x, t.right );
//		else if( t.left != null && t.right != null ) // Two children
//		{
//			t.getValue() = findMin( t.right ).element;
//			t.right = remove( t.getValue(), t.right );
//		}
//		else
//			t = ( t.left != null ) ? t.left : t.right;
//		return t;
//	}

	public TreeNode<T> deleteNode(TreeNode<T> t, T x) {
		if( t == null )
			return t;   // Item not found; do nothing
		if( x.compareTo( t.getValue() ) < 0 )
			t.left = deleteNode(t.left, x );
		else if( x.compareTo( t.getValue() ) > 0 )
			t.right = deleteNode(t.right,x );
		else if( t.left != null && t.right != null ) // Two children
		{
			t.value = findMin( t.right ).getValue();
			t.right = deleteNode(t.right,t.value );
		}
		else
			t = ( t.left != null ) ? t.left : t.right;
		return t;
	}


//	// Get minimum element in binary search tree
//	public TreeNode<T> inOrderSuccessor(TreeNode<T> root) {
//		if (root.left == null)
//			return root;
//		else {
//			return inOrderSuccessor(root.left);
//		}
//	}

//	public TreeNode<T> deleteNode(TreeNode<T> start, T value) {
//		if (start == null) {
//			return null;
//		}
//
//		if (start.getValue().compareTo(value) == 1) {
//			start.left = deleteNode(start.left, value);
//		} else if (start.getValue().compareTo(value) == -1) {
//			start.right = deleteNode(start.right, value);
//
//		} else {
//			// if nodeToBeDeleted have both children
//			if (start.left != null && start.right != null) {
//				TreeNode<T> temp = start;
//				// Finding minimum element from right
//				TreeNode<T> minNodeForRight = findMin(temp.right);
//				// Replacing current node with minimum node from right subtree
//				// Deleting minimum node from right now
//				deleteNode(start.right, minNodeForRight.getValue());
//			}
//			// if nodeToBeDeleted has only left child
//			else if (start.left != null) {
//				start = start.left;
//			}
//			// if nodeToBeDeleted has only right child
//			else if (start.right != null) {
//				start = start.right;
//			}
//			// if nodeToBeDeleted do not have child (Leaf node)
//			else
//				start = null;
//		}
//		return start;
//	}

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
