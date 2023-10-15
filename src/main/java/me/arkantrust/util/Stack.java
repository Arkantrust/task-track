package me.arkantrust.util;

public class Stack<E> {

    private List<E> stack;

    public Stack() {

        this.stack = new List<>();

    }

    public int size() {

        return stack.size();

    }

    public void push(E element) {

        stack.add(element);

    }

    public void checkEmpty() {

        if (isEmpty())
            throw new IllegalStateException("Stack is empty.");

    }

    public E pop() {

        checkEmpty();

        E top = stack.last();
        stack.remove(stack.size() - 1);
        return top;

    }

    public E peek() {

        checkEmpty();
        
        return stack.last();

    }

    public boolean isEmpty() {

        return stack.isEmpty();

    }

}
