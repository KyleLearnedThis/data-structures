package com.albion.common.tree.node;

public class BaseTreeNode<T> {
    public T value;
    public BaseTreeNode<T> left, right;

    BaseTreeNode(T d) {
        value = d;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BaseTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BaseTreeNode<T> left) {
        this.left = left;
    }

    public BaseTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BaseTreeNode<T> right) {
        this.right = right;
    }
}
