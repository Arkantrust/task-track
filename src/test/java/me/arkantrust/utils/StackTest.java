package me.arkantrust.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {

        stack = new Stack<>();

    }

    @Test
    public void testPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());

    }

    @Test
    public void testPop() {

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

    }

    @Test
    public void testPeek() {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek());
        assertEquals(3, stack.peek());

    }

    @Test
    public void testCheckEmpty() {

        assertThrows(IllegalStateException.class, () -> stack.peek());

    }
    
}
