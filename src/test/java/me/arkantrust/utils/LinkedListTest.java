package me.arkantrust.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.iterator().next());
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(1, list.iterator().next());
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
        list.add(1);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        Assertions.assertEquals(6, sum);
    }

    @Test
    public void testRemoveFirst() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());
        list.remove(0);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void testRemoveLast() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());
        list.remove(2);
        Assertions.assertEquals(1, list.iterator().next());
    }

    @Test
    public void testRemoveOutOfBounds() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

}