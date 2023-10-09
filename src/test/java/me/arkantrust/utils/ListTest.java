package me.arkantrust.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListTest {

    private List<Integer> list;

    @BeforeEach
    public void setUp() {

        list = new List<>();

    }

    @Test
    public void testAdd() {

        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));

    }

    @Test
    public void testRemove() {

        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());

        list.remove(1);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(3, list.get(1));

    }

    @Test
    public void testIsEmpty() {

        Assertions.assertTrue(list.isEmpty());
        list.add(1);
        Assertions.assertFalse(list.isEmpty());

    }

    @Test
    public void testGet() {

        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));

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
    public void testClear() {

        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();

        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());

    }

    @Test
    public void testSet() {

        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(4, list.get(1));
        Assertions.assertEquals(3, list.get(2));

    }

    @Test
    public void testContains() {

        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertTrue(list.contains(2));
        Assertions.assertFalse(list.contains(4));

    }

    @Test
    public void testIndexOf() {

        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(1, list.indexOf(2));
        Assertions.assertEquals(-1, list.indexOf(4));

    }

    @Test
    public void testGetFirst() {

        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(1, list.getFirst());

    }

    @Test
    public void testGetLast() {

        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(3, list.getLast());

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

}
