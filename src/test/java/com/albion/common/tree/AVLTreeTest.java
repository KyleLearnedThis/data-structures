package com.albion.common.tree;

import com.albion.common.tree.avl.AVLTree;
import org.testng.annotations.Test;

public class AVLTreeTest {
    @Test
    public void testInsert() throws Exception {
        AVLTree tree = new AVLTree();
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        BinaryTreePrinter.printNode(tree.root);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        BinaryTreePrinter.printNode(tree.root);
    }

}