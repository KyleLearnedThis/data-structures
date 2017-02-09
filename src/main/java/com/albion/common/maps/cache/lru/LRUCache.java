package com.albion.common.maps.cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Node> data;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>();
    }

    public int get(int key){
        if(data.containsKey(key)){
            // Move to first
            Node node = data.get(key);
            moveFirst(node);

            return node.value;
        }
        return -1;
    }

    public void set(int key, int value){
        // Existing slot
        if(data.containsKey(key)){
            Node node = data.get(key);
            node.value = value;
            moveFirst(node);
            return;
        }

        // Out of capacity, cleaning the oldest slot
        if(data.size() >= capacity){
            int id = tail.key;
            removeLast();
            data.remove(id);
        }

        // New slot
        Node node = new Node(key, value);
        add(node);
        data.put(key, node);
    }

    private void add(Node node){
        // Reset position
        node.prev = null;
        node.next = null;

        // First element
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        // Existing element
        head.prev = node;
        node.next = head;
        head = node;

    }

    private void remove(Node node){
        // Nothing to do
        if(node == null || head == null){
            return;
        }

        // The only one item
        if(head == tail && node == head){
            head = null;
            tail = null;
            return;
        }

        // Remove from head
        if(node == head){
            head.next.prev = null;
            head = head.next;
            return;
        }

        // Remove from end
        if(node == tail){
            tail.prev.next = null;
            tail = tail.prev;
            return;
        }

        // Remove in the middle
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    // move a node to the head (for a cache hit)
    private void moveFirst(Node node){
        remove(node);
        add(node);
    }

    // remove the oldest item which is the tail
    private void removeLast(){
        remove(tail);
    }

    public void printContents(){
        if(head == null){
            System.out.println("LRUCache is empty");
            return;
        }

        Node currNode = head;

        String contents = "";
        while(currNode != null){
            contents += String.format("%s ", currNode.value);
            currNode = currNode.next;
        }

        System.out.println(String.format("LRUCache contents : %s", contents));
    }
}
