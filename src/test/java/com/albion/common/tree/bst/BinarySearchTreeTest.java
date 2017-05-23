package com.albion.common.tree.bst;

import com.albion.common.tree.bst.traversal.InOrderTraversal;
import com.albion.common.tree.bst.traversal.LevelOrderTraversal;
import com.albion.common.tree.bst.traversal.PostOrderTraversal;
import com.albion.common.tree.bst.traversal.Traversal;
import com.albion.common.tree.bst.BinarySearchTree;
import com.albion.common.tree.node.BinarySearchTreeNode;
import com.albion.common.tree.utils.BinaryTreePrinter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class BinarySearchTreeTest {

	@DataProvider(name = "d01")
	public Object[][] testPrint01() {

			BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(2);
			BinarySearchTreeNode<Integer> n11 = new BinarySearchTreeNode<>(7);
			BinarySearchTreeNode<Integer> n12 = new BinarySearchTreeNode<>(5);
			BinarySearchTreeNode<Integer> n21 = new BinarySearchTreeNode<>(2);
			BinarySearchTreeNode<Integer> n22 = new BinarySearchTreeNode<>(6);
			BinarySearchTreeNode<Integer> n23 = new BinarySearchTreeNode<>(9);
			BinarySearchTreeNode<Integer> n31 = new BinarySearchTreeNode<>(5);
			BinarySearchTreeNode<Integer> n32 = new BinarySearchTreeNode<>(8);
			BinarySearchTreeNode<Integer> n33 = new BinarySearchTreeNode<>(4);

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
			BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(15);
			BinarySearchTreeNode<Integer> n06 = new BinarySearchTreeNode<>(6);
			BinarySearchTreeNode<Integer> n18 = new BinarySearchTreeNode<>(18);
			BinarySearchTreeNode<Integer> n03 = new BinarySearchTreeNode<>(3);
			BinarySearchTreeNode<Integer> n07 = new BinarySearchTreeNode<>(7);
			BinarySearchTreeNode<Integer> n17 = new BinarySearchTreeNode<>(17);
			BinarySearchTreeNode<Integer> n20 = new BinarySearchTreeNode<>(20);
			BinarySearchTreeNode<Integer> n02 = new BinarySearchTreeNode<>(2);
			BinarySearchTreeNode<Integer> n04 = new BinarySearchTreeNode<>(4);
			BinarySearchTreeNode<Integer> n13 = new BinarySearchTreeNode<>(13);
			BinarySearchTreeNode<Integer> n09 = new BinarySearchTreeNode<>(9);

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
	public void testTreePrint(BinarySearchTreeNode<Integer> root) {
		BinaryTreePrinter.printNode(root);
	}

	@Test(dataProvider = "d02")
	public void testInOrderTraversal(BinarySearchTreeNode<Integer> root) {
		Traversal t = new InOrderTraversal<>(root);
		t.traverse();
	}

	@Test(dataProvider = "d02")
	public void testPostOrderTraversal(BinarySearchTreeNode<Integer> root) {
		Traversal t = new PostOrderTraversal<>(root);
		t.traverse();
	}

	@Test(dataProvider = "d02")
	public void testLevelOrderTraversal(BinarySearchTreeNode<Integer> root) {
		BinaryTreePrinter.printNode(root);
		Traversal t = new LevelOrderTraversal<>(root);
		t.traverse();
	}

	@Test(dataProvider = "d02")
	public void testLevelOrderTraversalV2(BinarySearchTreeNode<Integer> root) {
		BinaryTreePrinter.printNode(root);
		LevelOrderTraversal<Integer> trv = new LevelOrderTraversal<>(root);
		List<List<Integer>> lists = trv.makeLevelOrderTree(root, true);
		for(List<Integer> list : lists) {
			for(Integer i : list) {
				System.out.print(" [" + i + "]");
			}
			System.out.println("");
		}
	}

	@Test
	public void testBinaryTreeProperties() {
		Integer[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinarySearchTree bt = new BinarySearchTree();

		for(Integer x : array) {
			bt.insert(x);
		}

		BinarySearchTreeNode<Integer> root = bt.getRoot();
		BinaryTreePrinter.printNode(root);

		BinarySearchTreeNode<Integer> seek = bt.find(9);
		if(seek != null) {
			seek.print();
		}
		Assert.assertTrue(seek != null);
	}

	@Test
	public void testFindParent() {
		Integer[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinarySearchTree bt = new BinarySearchTree();

		for(Integer x : array) {
			bt.insert(x);
		}

		BinarySearchTreeNode<Integer> root = bt.getRoot();
		BinaryTreePrinter.printNode(root);

		BinarySearchTree bst = new BinarySearchTree(root);
		BinarySearchTreeNode<Integer> parent = bst.findParent(17);
		int parentID = parent.getValue();
		Assert.assertEquals(parentID, 18);
	}

	@Test
	public void testValidBST() {
		Integer[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinarySearchTree<Integer> bt = new BinarySearchTree();

		for(Integer x : array) {
			bt.insert(x);
		}

		BinarySearchTreeNode<Integer> root = bt.getRoot();
		BinaryTreePrinter.printNode(root);

		boolean actual = bt.isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		Assert.assertEquals(actual, true);
	}


	@Test(dataProvider = "d02")
	public void testDeleteNode(BinarySearchTreeNode<Integer> root) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);
		BinaryTreePrinter.printNode(root);
		tree.deleteNode(root, 15);
		System.out.println("[After delete]");
		BinaryTreePrinter.printNode(root);
	}
}
