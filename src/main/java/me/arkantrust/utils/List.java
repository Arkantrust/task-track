package me.arkantrust.utils;

import java.util.Arrays;
import java.util.Iterator;

public class List<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public List() {

        this(DEFAULT_CAPACITY);

    }

    public List(int initialCapacity) {

        this.data = new Object[initialCapacity];
        this.size = 0;

    }

    public void add(T element) {

        ensureCapacity();
        data[size++] = element;

    }

    public void remove(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        }

        for (int i = index; i < size - 1; i++) {

            data[i] = data[i + 1];

        }

        size--;

    }

    public boolean isEmpty() {

        return size == 0;

    }

    @SuppressWarnings("unchecked")
    public T get(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        return (T) data[index];

    }

    public int size() {

        return size;

    }

    private void ensureCapacity() {

        if (size == data.length)
            data = Arrays.copyOf(data, data.length * 2);

    }

    public void clear() {

        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;

    }

    public void set(int index, T element) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        data[index] = element;

    }

    public boolean contains(T element) {

        for (int i = 0; i < size; i++) {

            if (data[i].equals(element))
                return true;

        }

        return false;

    }

    public int indexOf(T element) {

        for (int i = 0; i < size; i++) {

            if (data[i].equals(element))
                return i;

        }

        return -1;

    }

    @SuppressWarnings("unchecked")
    public T getFirst() {

        return (T) data[0];

    }

    @SuppressWarnings("unchecked")
    public T getLast() {

        return (T) data[size - 1];

    }

    @Override
    public Iterator<T> iterator() {

        return new DynamicArrayIterator();

    }

    private class DynamicArrayIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {

            return currentIndex < size;

        }

        @Override
        public T next() {

            if (!hasNext())
                throw new java.util.NoSuchElementException();

            return get(currentIndex++);

        }

    }

}
