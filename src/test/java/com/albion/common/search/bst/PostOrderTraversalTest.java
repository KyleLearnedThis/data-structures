package com.albion.common.search.bst;

import com.albion.common.tree.BinarySearchTree;
import com.albion.common.tree.BinaryTreePrinter;
import com.albion.common.tree.node.BinarySearchTreeNode;
import org.testng.annotations.Test;

public class PostOrderTraversalTest {
    @Test
    public void testTraverse() throws Exception {
        Integer[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> bt = new BinarySearchTree();

        for(Integer x : array) {
            bt.insert(x);
        }

        BinarySearchTreeNode<Integer> root = bt.getRoot();
        BinaryTreePrinter.printNode(root);

        Traversal traversal = new PostOrderTraversal<>(root);
        traversal.traverse();
    }

}