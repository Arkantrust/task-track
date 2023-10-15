package me.arkantrust.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListTest {

    private List<Integer> list;

    @BeforeEach
    public void setUp() {

        list = new List<>();

    }

    @Test
    public void testIsEmpty() {

        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());

    }

    @Test
    public void testAdd() {

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

    }

    @Test
    public void testRemove() {

        list.add(1);

        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveFirst() {

        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(0);
        assertEquals(2, list.size());

        list.remove(0);
        assertEquals(1, list.size());

        list.remove(0);
        assertTrue(list.isEmpty());

    }

    @Test
    public void testRemoveLast() {

        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(2);
        assertEquals(2, list.size());

        list.remove(1);
        assertEquals(1, list.size());

        list.remove(0);
        assertTrue(list.isEmpty());

    }

    @Test
    public void testGet() {

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

    }

    @Test
    public void testSize() {

        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());

    }

    @Test
    public void testClear() {

        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

    }

    @Test
    public void testSet() {

        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(3, list.get(2));

    }

    @Test
    public void testContains() {

        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(2));
        assertFalse(list.contains(4));

    }

    @Test
    public void testIndexOf() {

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(4));

    }

    @Test
    public void testGetFirst() {

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.first());

    }

    @Test
    public void testGetLast() {

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.last());

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

        assertEquals(6, sum);

    }

}
