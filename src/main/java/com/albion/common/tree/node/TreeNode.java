package com.albion.common.tree.node;

public class TreeNode<T> extends BaseTreeNode<T>{
    public int height;
    public TreeNode(T d) {
        super(d);
        height = 1;
    }

    public void setLeft(TreeNode<T> l) {
        left = l;
    }

    public void setRight(TreeNode<T> r) {
        right = r;
    }

    @Override
    public TreeNode<T> getLeft() {
        BaseTreeNode<T> left = this.left;
        return (TreeNode<T>) left;
    }

    @Override
    public TreeNode<T> getRight() {
        BaseTreeNode<T> right = this.right;
        return (TreeNode<T>) right;
    }
}
