package me.arkantrust.utils;

public class Queue<E> {

    private List<E> queue;

    public Queue() {

        this.queue = new List<>();

    }

    public int size() {

        return queue.size();

    }

    public void enqueue(E element) {

        queue.add(element);

    }

    public void checkEmpty() {

        if (isEmpty())
            throw new IllegalStateException("Queue is empty.");

    }

    public E dequeue() {

        checkEmpty();

        E head = queue.first();
        queue.remove(0);
        return head;

    }

    public E peek() {

        checkEmpty();

        return queue.first();

    }

    public boolean isEmpty() {

        return queue.isEmpty();

    }

    public void clear() {

        queue.clear();

    }

}
