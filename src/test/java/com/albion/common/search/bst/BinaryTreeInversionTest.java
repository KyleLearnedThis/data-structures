package com.albion.common.search.bst;

import com.albion.common.tree.BinarySearchTree;
import com.albion.common.tree.BinaryTreePrinter;
import com.albion.common.tree.TreeNode;
import org.testng.annotations.Test;


public class BinaryTreeInversionTest {
    @Test
    public void testInvert() throws Exception {
        Integer[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree bt = new BinarySearchTree();

        for(Integer x : array) {
            bt.insert(x);
        }

        TreeNode<Integer> root = bt.getRoot();
        BinaryTreePrinter.printNode(root);

        BinaryTreeInversion<Integer> bti = new BinaryTreeInversion<>(root);
        bti.invert();
        BinaryTreePrinter.printNode(root);
    }

}