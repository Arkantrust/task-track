package me.arkantrust.utils;

import java.util.NoSuchElementException;

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
    public void testPutDuplicatedKey() {

        map.put("one", 1);
        map.put("one", 2);
        Assertions.assertEquals(2, map.get("one"));

    }

    @Test
    public void testGetNullKey() {

        Assertions.assertThrows(NullPointerException.class, () -> map.get(null));

    }

    @Test
    public void testGetNonExistentKey() {

        Assertions.assertThrows(NoSuchElementException.class, () -> map.get("one"));

    }

    @Test
    public void testIsEmpty() {

        Assertions.assertTrue(map.isEmpty());

        map.put("one", 1);

        Assertions.assertFalse(map.isEmpty());

    }

    @Test
    public void testGetIndex() {

        for (int i = 1; i < 4; i++) {

            map.put("key" + i, i);

        }

        int index1 = map.get("key1");
        int index2 = map.get("key2");
        int index3 = map.get("key3");

        Assertions.assertEquals(index1, map.get("key1"));
        Assertions.assertEquals(index2, map.get("key2"));
        Assertions.assertEquals(index3, map.get("key3"));

    }

    @Test
    public void testResize() {

        for (int i = 1; i <= 50; i++) {

            map.put("key" + i, i);

        }

        Assertions.assertEquals(50, map.get("key50"));

    }

}