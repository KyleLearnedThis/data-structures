package com.albion.common.search.bst;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.albion.common.search.bst.Traversal;
import com.albion.common.tree.BinaryTree;
import com.albion.common.tree.BinaryTreePrinter;
import com.albion.common.tree.TreeNode;

public class BinaryTreeTest {

//	@Test
//	public void testInsert() {
//		BinaryTree bt = new BinaryTree();
//		int[] data = {5,2,6,4,10,8};
//		for(int i = 0; i < data.length; i++ ){
//			bt.insert(data[i]);
//		}
////		bt.traverse();
//		
//		TreeNode<Integer> t = bt.binarySearch(10);
//		Assert.assertTrue(t != null, "nothing found!!!!!!");
//		Assert.assertEquals(t.getValue().toString(), "10");
//		
//		bt.delete(5);
//		bt.traverse();
//	}
	
	@DataProvider(name = "d01")
	public Object[][] testPrint01() {
	
	        TreeNode<Integer> root = new TreeNode<Integer>(2);
	        TreeNode<Integer> n11 = new TreeNode<Integer>(7);
	        TreeNode<Integer> n12 = new TreeNode<Integer>(5);
	        TreeNode<Integer> n21 = new TreeNode<Integer>(2);
	        TreeNode<Integer> n22 = new TreeNode<Integer>(6);
	        TreeNode<Integer> n23 = new TreeNode<Integer>(9);
	        TreeNode<Integer> n31 = new TreeNode<Integer>(5);
	        TreeNode<Integer> n32 = new TreeNode<Integer>(8);
	        TreeNode<Integer> n33 = new TreeNode<Integer>(4);

	        root.left = n11;
	        root.right = n12;

	        n11.left = n21;
	        n11.right = n22;

	        n12.right = n23;
	        n22.left = n31;
	        n22.right = n32;

	        n23.left = n33;

	        Object[][] retVal = new Object[][] {{root}};
	        return retVal;
	}
	
	@DataProvider(name = "d02")
	public Object[][] buildBinarySearchTree02() {
			//Page 290
	        TreeNode<Integer> root = new TreeNode<Integer>(15);
	        TreeNode<Integer> n06 = new TreeNode<Integer>(6);
	        TreeNode<Integer> n18 = new TreeNode<Integer>(18);
	        TreeNode<Integer> n03 = new TreeNode<Integer>(3);
	        TreeNode<Integer> n07 = new TreeNode<Integer>(7);
	        TreeNode<Integer> n17 = new TreeNode<Integer>(17);
	        TreeNode<Integer> n20 = new TreeNode<Integer>(20);
	        TreeNode<Integer> n02 = new TreeNode<Integer>(2);
	        TreeNode<Integer> n04 = new TreeNode<Integer>(4);
	        TreeNode<Integer> n13 = new TreeNode<Integer>(13);
	        TreeNode<Integer> n09 = new TreeNode<Integer>(9);
	        
	        root.parent = null;
	        root.left = n06;
	        root.right = n18;
	        
	        n06.left = n03;
	        n06.right = n07;
	        n06.parent = root;
	        
	        n18.left = n17;
	        n18.right = n20;
	        n18.parent = root;
	        
	        n03.left = n02;
	        n03.right = n04;
	        n03.parent = n06;
	        
	        n07.right = n13;
	        n07.parent = n06;

	        n17.parent = n18;
	        n20.parent = n18;
	        
	        n13.left = n09;
	        n13.parent = n07;
	        
	        n09.parent = n13;
	        
	        Object[][] retVal = new Object[][] {{root}};
	        return retVal;
	}
	
	
	
	@Test(dataProvider = "d02")
	public void testTreePrint(TreeNode<Integer> root) {
		BinaryTreePrinter.printNode(root);
	}
	
	@Test(dataProvider = "d02")
	public void testInOrderTraversal(TreeNode<Integer> root) {
		Traversal t = new InOrderTraversal<Integer>(root);
		t.traverse();
	}
	
	@Test(dataProvider = "d02")
	public void testPostOrderTraversal(TreeNode<Integer> root) {
		Traversal t = new PostOrderTraversal<Integer>(root);
		t.traverse();
	}
	
	@Test
	public void testBinaryTreeProperties() {
		Integer[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinaryTree bt = new BinaryTree();
		
		for(Integer x : array) {
			bt.insert(x);
		}
		
		TreeNode<Integer> root = bt.getRoot();
		BinaryTreePrinter.printNode(root);
		
		TreeNode<Integer> seek = bt.find(9);
		if(seek != null) {
			seek.print();
		}
		Assert.assertTrue(seek != null);
	}
	
	
	@Test
	public void testInversion() {
		Integer[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinaryTree bt = new BinaryTree();
		
		for(Integer x : array) {
			bt.insert(x);
		}
		
		TreeNode<Integer> root = bt.getRoot();
		BinaryTreePrinter.printNode(root);
		
		BinaryTreeInversion bti = new BinaryTreeInversion(root);
		bti.invert();
		
		BinaryTreePrinter.printNode(root);
	}
}
