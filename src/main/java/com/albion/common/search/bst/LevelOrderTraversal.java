package com.albion.common.search.bst;


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
        Queue<BaseTreeNode<T>> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BaseTreeNode<T> node = queue.poll();
            node.print();
            if(node.left!=null) {
                queue.add(node.getLeft());
            }
            if(node.right!=null) {
                queue.add(node.getRight());
            }
        }
    }

    public List<List<T>> makeLevelOrderTree(BaseTreeNode<T> root) {
        Queue<BaseTreeNode<T>> queue = new LinkedList<>();
        List<List<T>> wrapList = new LinkedList<>();

        if(root == null) {
            return wrapList;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<T> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) {
                    queue.offer(queue.peek().getLeft());
                }
                if(queue.peek().right != null) {
                    queue.offer(queue.peek().getRight());
                }
                subList.add(queue.poll().value);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
