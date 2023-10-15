package me.arkantrust.utils;

import java.util.Arrays;
import java.util.Iterator;

public class List<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    private E first;
    private E last;

    public List() {

        this(DEFAULT_CAPACITY);

    }

    public List(int initialCapacity) {

        this.data = new Object[initialCapacity];
        this.size = 0;

    }

    public E first() {

        return this.first;

    }

    public E last() {

        return this.last;

    }

    public boolean isEmpty() {

        return size == 0;

    }

    public int size() {

        return size;

    }

    public void clear() {

        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.first = null;
        this.last = null;

    }

    @Override
    public Iterator<E> iterator() {

        return new ListIterator();

    }

    private class ListIterator implements Iterator<E> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {

            return currentIndex < size;

        }

        @Override
        public E next() {

            if (!hasNext())
                throw new java.util.NoSuchElementException();

            return get(currentIndex++);

        }

    }

    public void add(E element) {

        if (element == null)
            throw new IllegalArgumentException("Element cannot be null.");

        if (this.size == data.length)
            data = Arrays.copyOf(data, data.length * 2);

        if (this.size == 0) {

            this.first = element;
            this.last = element;

        } else {

            this.last = element;

        }

        data[size++] = element;

    }

    private void checkIndex(int index) {

        if (index < 0 || index > this.size - 1 || this.size == 0)
            throw new IndexOutOfBoundsException("Index" + index + " out of bounds for size " + this.size + ".");

    }

    @SuppressWarnings("unchecked")
    public E get(int index) {

        checkIndex(index);

        if (index == 0)
            return this.first;

        else if (index == this.size - 1)
            return this.last;

        return (E) data[index];

    }

    @SuppressWarnings("unchecked")
    public void remove(int index) {

        checkIndex(index);

        if (index == this.size - 1) {

            data[index] = null;
            size--;

            if (!isEmpty())
                this.last = (E) data[this.size - 1];

        } else {

            for (int i = index; i < this.size - 1; i++) {

                data[i] = data[i + 1];

            }

            this.first = (E) data[0];
            this.last = (E) data[this.size - 1];

            size--;

        }

    }

    public void set(int index, E element) {

        checkIndex(index);

        data[index] = element;

    }

    public boolean contains(E element) {

        if (element == null)
            throw new IllegalArgumentException("Element cannot be null.");

        for (int i = 0; i < size; i++) {

            if (data[i].equals(element))
                return true;

        }

        return false;

    }

    public int indexOf(E element) {

        for (int i = 0; i < size; i++) {

            if (data[i].equals(element))
                return i;

        }

        return -1;

    }

}
