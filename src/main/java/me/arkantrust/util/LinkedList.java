package me.arkantrust.util;

import java.util.Iterator;

class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {

        this.data = data;
        this.next = null;
    
    }

}

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {

        this.head = null;
        this.size = 0;

    }

    public void add(T data) {
        
        Node<T> newNode = new Node<>(data);
        
        if (head == null) {
        
            head = newNode;
        
        } else {
        
            Node<T> current = head;
            while (current.next != null) {
        
                current = current.next;
        
            }
        
            current.next = newNode;
        
        }

        size++;
    
    }

    public void remove(int index) {
    
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        if (index == 0) {

            head = head.next;
        
        } else {
        
            Node<T> current = head;
        
            for (int i = 0; i < index - 1; i++) {
        
                current = current.next;
        
            }
        
            current.next = current.next.next;
        
        }
        
        size--;
    
    }

    public boolean isEmpty() {
    
        return size == 0;
    
    }

    public int size() {
    
        return size;
    
    }

    @Override
    public Iterator<T> iterator() {
    
        return new CustomLinkedListIterator();
    
    }

    private class CustomLinkedListIterator implements Iterator<T> {
    
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
    
            return current != null;
    
        }

        @Override
        public T next() {
    
            if (!hasNext())
                throw new java.util.NoSuchElementException();

            T data = current.data;
            current = current.next;
            return data;

        }

    }

    // Other methods like remove, get, etc will be implemented here if needed

}
