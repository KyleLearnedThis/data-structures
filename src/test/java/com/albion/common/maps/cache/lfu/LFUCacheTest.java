package com.albion.common.maps.cache.lfu;

import org.testng.annotations.Test;

public class LFUCacheTest {
    @Test
    public void testBasic() throws Exception {
        int[] keys = {1,2,3,4,5,6};
        String[] vals = {"Apple", "Bacon", "Cod", "Dill", "Edelweiss", "Fig"};

        LFUCache cache = new LFUCache(5);
        for (int i = 0; i < keys.length; i++) {
            cache.add(keys[i], vals[i]);
        }
        cache.printCacheEntries();
        System.out.println("==============");
        cache.printMap();
    }

    @Test
    public void testGet() throws Exception {
        int[] keys = {1,2,3,4,5,6};
        String[] vals = {"Apple", "Bacon", "Cod", "Dill", "Edelweiss", "Fig"};

        LFUCache cache = new LFUCache(5);
        for (int i = 0; i < keys.length; i++) {
            cache.add(keys[i], vals[i]);
        }
        cache.printCacheEntries();
        System.out.println("======= BEFORE =======");
        cache.printMap();

        for (int i = 0; i < 4; i++) {
            cache.get(2);
            cache.get(3);
            cache.get(4);
            cache.get(5);
        }

        for (int i = 0; i < 3; i++) {
            cache.get(2);
            cache.get(3);
            cache.get(4);
        }

        for (int i = 0; i < 2; i++) {
            cache.get(2);
            cache.get(3);
        }

        cache.get(2);

        System.out.println("======= AFTER 1 =======");
        cache.printMap();

        cache.add(7, "Gum");
        System.out.println("======= AFTER 2 =======");
        cache.printMap();
    }
}