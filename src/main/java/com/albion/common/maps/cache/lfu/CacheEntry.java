package com.albion.common.maps.cache.lfu;

public class CacheEntry implements Comparable {
    private String data;
    private int frequency;

    public CacheEntry(String d, int f){
        data = d;
        frequency = f;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int incrementFrequency(){
        frequency++;
        return frequency;
    }
    public void print() {
        System.out.println("[data: " + data + "] [freq: " + frequency + "]");
    }
    @Override
    public int compareTo(Object o) {
        CacheEntry entry = (CacheEntry) o;
        int result = this.frequency - entry.frequency;
        return result;
    }
}