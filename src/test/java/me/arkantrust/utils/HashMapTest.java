package me.arkantrust.utils;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
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

        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));

    }

    @Test
    public void testPutDuplicatedKey() {

        map.put("one", 1);
        map.put("one", 2);
        
        assertEquals(2, map.get("one"));

    }

    @Test
    public void testGetNullKey() {

        assertThrows(NullPointerException.class, () -> map.get(null));

    }

    @Test
    public void testGetNonExistentKey() {

        assertThrows(NoSuchElementException.class, () -> map.get("one"));

    }

    @Test
    public void testIsEmpty() {

        assertTrue(map.isEmpty());

        map.put("one", 1);

        assertFalse(map.isEmpty());

    }

    @Test
    public void testGetIndex() {

        for (int i = 1; i < 4; i++) {

            map.put("key" + i, i);

        }

        int index1 = map.get("key1");
        int index2 = map.get("key2");
        int index3 = map.get("key3");

        assertEquals(index1, map.get("key1"));
        assertEquals(index2, map.get("key2"));
        assertEquals(index3, map.get("key3"));

    }

    @Test
    public void testResize() {

        for (int i = 1; i <= 50; i++) {

            map.put("key" + i, i);

        }

        assertEquals(50, map.get("key50"));

    }

}