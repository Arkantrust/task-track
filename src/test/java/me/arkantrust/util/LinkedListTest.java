package me.arkantrust.util;

import static org.junit.jupiter.api.Assertions.*;
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
    
        assertEquals(3, list.size());
        assertEquals(1, list.iterator().next());
    
    }

    @Test
    public void testRemove() {
    
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
    
        assertEquals(2, list.size());
        assertEquals(1, list.iterator().next());
    
    }

    @Test
    public void testIsEmpty() {
    
        assertTrue(list.isEmpty());
    
        list.add(1);
    
        assertFalse(list.isEmpty());
    
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

    @Test
    public void testRemoveFirst() {
    
        list.add(1);
        list.add(2);
        list.add(3);
    
        assertEquals(3, list.size());
    
        list.remove(0);
    
        assertEquals(2, list.size());
    
    }

    @Test
    public void testRemoveLast() {
    
        list.add(1);
        list.add(2);
        list.add(3);
    
        assertEquals(3, list.size());
    
        list.remove(2);
    
        assertEquals(1, list.iterator().next());
    
    }

    @Test
    public void testRemoveOutOfBounds() {
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            
            list.remove(0);
        
        });
    
    }

}