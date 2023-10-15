package me.arkantrust.util;

import java.util.Arrays;

public class PriorityQueue<E extends Comparable<E>> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue() {

        heap = (E[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;

    }

    @SuppressWarnings("unchecked")
    public void clear() {

        heap = (E[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;

    }

    public void insert(E item) {

        if (size == heap.length - 1)
            resizeHeap();

        size++;
        int index = size;

        while (index > 1 && item.compareTo(heap[index / 2]) > 0) {

            heap[index] = heap[index / 2];
            index /= 2;

        }

        heap[index] = item;

    }

    public int size() {

        return this.size;

    }

    public E remove() {

        if (isEmpty())
            return null;

        E max = heap[1];
        heap[1] = heap[size];
        heap[size] = null;
        size--;

        heapify(1);

        return max;
    }

    public boolean isEmpty() {

        return size == 0;

    }

    private void resizeHeap() {

        heap = Arrays.copyOf(heap, heap.length * 2);

    }

    private void heapify(int index) {

        int max = index;
        int left = 2 * index;
        int right = 2 * index + 1;

        if (left <= size && heap[left].compareTo(heap[max]) > 0)
            max = left;

        if (right <= size && heap[right].compareTo(heap[max]) > 0)
            max = right;

        if (max != index) {

            E temp = heap[index];

            heap[index] = heap[max];
            heap[max] = temp;
            heapify(max);

        }

    }

    public E peek() {

        if (isEmpty())
            return null;

        return heap[1];

    }

}
