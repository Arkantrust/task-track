package me.arkantrust.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    private HashMap<String, Integer> map;

    @BeforeEach
    public void setUp() {

        map = new HashMap<>();

    }

    @Test
    public void testPutAndGet() {
    
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
    
        Assertions.assertEquals(1, map.get("one"));
        Assertions.assertEquals(2, map.get("two"));
        Assertions.assertEquals(3, map.get("three"));
    
    }

    @Test
    public void testPutDuplicateKey() {
    
        map.put("one", 1);
        map.put("one", 2);
        Assertions.assertEquals(2, map.get("one"));
    
    }

    @Test
    public void testGetNonExistentKey() {
    
        Assertions.assertNull(map.get("one"));
    
    }

    @Test
    public void testIsEmpty() {
    
        Assertions.assertTrue(map.isEmpty());
        map.put("one", 1);
        Assertions.assertFalse(map.isEmpty());
    
    }

    @Test
    public void testGetIndex() {
    
        int index1 = map.get("one");
        int index2 = map.get("two");
        int index3 = map.get("three");
    
        Assertions.assertEquals(index1, map.get("one"));
        Assertions.assertEquals(index2, map.get("two"));
        Assertions.assertEquals(index3, map.get("three"));
    
    }

    @Test
    public void testResize() {

        for (int i = 0; i < 100; i++) {
        
            map.put("key" + i, i);
        
        }
        
        Assertions.assertEquals(100, map.get("key99"));
    
    }

}