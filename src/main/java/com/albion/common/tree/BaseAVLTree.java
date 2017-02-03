package com.albion.common.tree;

import com.albion.common.tree.node.TreeNode;

abstract public class BaseAVLTree<T extends Comparable<T>> {
    public TreeNode<T> root;

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to get height of the tree
    int height(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    TreeNode<T> rightRotate(TreeNode<T> y) {
        TreeNode<T> x = y.getLeft();
        TreeNode<T> T2 = x.getRight();

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.getLeft()), height(y.getRight())) + 1;
        x.height = max(height(x.getLeft()), height(x.getRight())) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    TreeNode<T> leftRotate(TreeNode<T> x) {
        TreeNode<T> y = x.getRight();
        TreeNode<T> T2 = y.getLeft();

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.getLeft()), height(x.getRight())) + 1;
        y.height = max(height(y.getLeft()), height(y.getRight())) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(TreeNode<T> N) {
        if (N == null) {
            return 0;
        }
        return height(N.getLeft()) - height(N.getRight());
    }
}
