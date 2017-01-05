package com.albion.common.search.bst;


import com.albion.common.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal <T extends Comparable<?>> implements Traversal{
    protected TreeNode<T> root;

    public LevelOrderTraversal(TreeNode<T> x) {
        root = x;
    }

    @Override
    public void traverse() {
        Queue<TreeNode<T>> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.print();
            if(node.left!=null) {
                queue.add(node.left);
            }
            if(node.right!=null) {
                queue.add(node.right);
            }
        }
    }

    public List<List<T>> makeLevelOrderTree(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        List<List<T>> wrapList = new LinkedList<>();

        if(root == null) {
            return wrapList;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<T> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().value);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
