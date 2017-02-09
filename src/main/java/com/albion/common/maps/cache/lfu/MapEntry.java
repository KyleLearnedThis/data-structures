package com.albion.common.maps.cache.lfu;

public class MapEntry implements Comparable {

    public Integer key;
    public CacheEntry value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public CacheEntry getValue() {
        return value;
    }

    public void setValue(CacheEntry value) {
        this.value = value;
    }

    public MapEntry(int k, CacheEntry v) {
        key = k;
        value = v;
    }

    @Override
    public int compareTo(Object o) {
        MapEntry m = (MapEntry) o;
        CacheEntry mValue = m.value;
        return value.compareTo(mValue);
    }

    public void print() {
        System.out.println("=== key " + key + "===");
        value.print();
    }
}
