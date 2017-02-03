package com.albion.common.tree;

import com.albion.common.tree.node.TreeNode;

public class AVLTree extends BaseAVLTree<Integer> {
    TreeNode<Integer> insert(TreeNode<Integer> node, Integer key) {
        /* 1.  Perform the normal BST insertion */
        if (node == null) {
            return (new TreeNode<Integer>(key));
        }
        if (key < node.value) {
            TreeNode<Integer> left = node.getLeft();
            left = insert(node.getLeft(), key);
        }
        else if (key > node.value) {
            TreeNode<Integer> right = node.getRight();
            right = insert(node.getRight(), key);
        }
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.getLeft()),
                height(node.getRight()));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.value) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.value) {
            TreeNode<Integer> left = node.getLeft();
            left = leftRotate(node.getLeft());
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.value) {
            TreeNode<Integer> right = node.getRight();
            right = rightRotate(node.getRight());
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }
}
