package me.arkantrust.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {

        queue = new Queue<>();

    }

    @Test
    public void testEnqueue() {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
    }

    @Test
    public void testDequeue() {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());

    }

    @Test
    public void testPeek() {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());

    }

    @Test
    public void testCheckEmpty() {

        assertThrows(IllegalStateException.class, () -> queue.peek());

    }

}
