package com.albion.common.maps.basic;

import org.testng.annotations.Test;

public class BasicMapTest {
    @Test
    public void testAdd() throws Exception {
        BasicMap<String, Integer> map = new BasicMap<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }

}