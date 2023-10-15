package me.arkantrust.utils;

public class Stack<T> {

    private List<T> stack;

    public Stack() {

        this.stack = new List<>();

    }

    public int size() {

        return stack.size();

    }

    public void push(T element) {

        stack.add(element);

    }

    public T pop() {

        if (isEmpty())
            throw new IllegalStateException("Stack is empty.");

        T element = stack.getLast();
        stack.remove(stack.size() - 1);
        return element;

    }

    public T peek() {

        if (isEmpty())
            throw new IllegalStateException("Stack is empty.");

        return stack.getLast();

    }

    public boolean isEmpty() {

        return stack.isEmpty();

    }

}
