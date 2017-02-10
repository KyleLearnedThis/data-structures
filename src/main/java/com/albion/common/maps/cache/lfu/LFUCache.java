package com.albion.common.maps.cache.lfu;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {
    private int initialCapacity = 10;
    private PriorityQueue<MapEntry> entries = new PriorityQueue<>();
    private LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<>();

    public LFUCache(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public void add(int key, String data) {
        if(!isFull()) {
            CacheEntry cacheEntry = new CacheEntry(data, 1);
            MapEntry entry = new MapEntry(key, cacheEntry);
            entries.add(entry);
            cacheMap.put(key, cacheEntry);
        } else {
            MapEntry mapEntry = entries.poll();
            int removeKey = mapEntry.getKey();
            cacheMap.remove(removeKey);

            CacheEntry cacheEntry = new CacheEntry(data, 1);
            mapEntry = new MapEntry(key, cacheEntry);
            entries.add(mapEntry);
            cacheMap.put(key, cacheEntry);
        }
    }

    public String get(int key) {
        // cache hit
        if(cacheMap.containsKey(key)) {
            CacheEntry e1 = cacheMap.get(key);
            e1.incrementFrequency();
            reshufflePriorityQueue(key);
            cacheMap.put(key, e1);
            return e1.getData();
        }
        // cache miss
        return null;
    }

    public boolean isFull() {
        if(cacheMap.size() == initialCapacity) {
            return true;
        }
        return false;
    }

    public void printCacheEntries() {
        Iterator<MapEntry> iterator = this.entries.iterator();
        while(iterator.hasNext()){
            MapEntry entry = iterator.next();
            entry.print();
        }
    }

    public void printMap(){
        for(Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet()){
            int key = entry.getKey();
            CacheEntry cacheEntry = entry.getValue();
            System.out.print("[key : " + key + "] ");
            cacheEntry.print();
        }
    }

    public MapEntry findEntry(int key){
        Iterator<MapEntry> iterator = entries.iterator();
        while(iterator.hasNext()){
            MapEntry entry = iterator.next();
            int k = entry.getKey();
            if(k == key) {
                return entry;
            }
        }
        return null;
    }

    public void reshufflePriorityQueue(int key){
        MapEntry entry = findEntry(key);
        if(entry!= null) {
            entries.remove(entry);
            entries.add(entry);
        }
    }
}
