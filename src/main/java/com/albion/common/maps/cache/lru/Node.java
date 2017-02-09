package com.albion.common.maps.cache.lru;

public class Node {
    public Node prev;
    public Node next;
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
