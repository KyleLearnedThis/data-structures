package com.albion.common.tree.bst.traversal;

import com.albion.common.tree.bst.BinarySearchTree;
import com.albion.common.tree.bst.traversal.InOrderTraversal;
import com.albion.common.tree.bst.traversal.Traversal;
import com.albion.common.tree.utils.BinaryTreePrinter;
import com.albion.common.tree.node.BinarySearchTreeNode;
import org.testng.annotations.Test;

public class InOrderTraversalTest {
    @Test
    public void testTraverse() throws Exception {
        Integer[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> bt = new BinarySearchTree();

        for(Integer x : array) {
            bt.insert(x);
        }

        BinarySearchTreeNode<Integer> root = bt.getRoot();
        BinaryTreePrinter.printNode(root);

        Traversal traversal = new InOrderTraversal<>(root);
        traversal.traverse();
    }

}