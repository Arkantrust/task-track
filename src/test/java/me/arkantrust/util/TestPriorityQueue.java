package me.arkantrust.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPriorityQueue {

    private PriorityQueue<Integer> queue;

    @BeforeEach
    public void setUp() {

        queue = new PriorityQueue<>();

    }

    @Test
    public void testinsert() {

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        assertEquals(3, queue.peek());
        assertEquals(3, queue.size());

    }

    @Test
    public void testSize() {

        assertEquals(0, queue.size());

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        assertEquals(3, queue.size());

    }

    @Test
    public void testPeek() {

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        assertEquals(3, queue.peek());

    }

    @Test
    public void testIsEmpty() {

        assertTrue(queue.isEmpty());

        queue.insert(1);

        assertFalse(queue.isEmpty());

    }

    @Test
    public void testClear() {
        
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.clear();
        
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    
    }

    @Test
    public void testRemove() {

        int[] elements = { 10, 40, 30, 25, 5, 400 };

        for (int element : elements) {

            queue.insert(element);

        }

        assertEquals(400, queue.remove());
        assertEquals(40, queue.remove());
        assertEquals(30, queue.remove());
        assertEquals(25, queue.remove());
        assertEquals(10, queue.remove());
        assertEquals(5, queue.remove());
        assertTrue(queue.isEmpty());

    }

}
