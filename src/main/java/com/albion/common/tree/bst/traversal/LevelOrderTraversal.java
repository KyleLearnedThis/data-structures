package com.albion.common.tree.bst.traversal;


import com.albion.common.tree.node.BaseTreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal <T extends Comparable<?>> implements Traversal{
    protected BaseTreeNode<T> root;

    public LevelOrderTraversal(BaseTreeNode<T> x) {
        root = x;
    }

    @Override
    public void traverse() {
        Queue<BaseTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BaseTreeNode<T> node = queue.poll();
            node.print();
            if(node.left != null) {
                queue.add(node.getLeft());
            }
            if(node.right != null) {
                queue.add(node.getRight());
            }
        }
        System.out.println("");
    }

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
     * @param root
     * @param isBottomUp If true, put leaves at top.
     * @return
     */
    public List<List<T>> makeLevelOrderTree(BaseTreeNode<T> root, boolean isBottomUp) {
        Queue<BaseTreeNode<T>> queue = new LinkedList<>();
        List<List<T>> resultLists = new LinkedList<>();

        if(root == null) {
            return resultLists;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<T> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++) {
                BaseTreeNode<T> node = queue.remove();
                BaseTreeNode<T> left = node.getLeft();
                BaseTreeNode<T> right = node.getRight();

                if(left != null) {
                    queue.add(left);
                }

                if(right != null) {
                    queue.add(right);
                }

                subList.add(node.getValue());
            }
            if(!isBottomUp){
                resultLists.add(subList);
            } else {
                resultLists.add(0, subList);
            }
        }
        return resultLists;
    }
}
