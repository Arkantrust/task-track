package me.arkantrust.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Bucket<K, V> {

    private K key;
    private V value;
    private Bucket<K, V> next;

}

public class HashTable<K, V> {
    private Bucket<K, V>[] buckets;
    private int numOfBuckets; // capacity of HashTable
    private int size; // number of values stored

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        buckets = new Bucket[capacity];
        this.size = 0;
    }

    public int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % numOfBuckets; // temporary module function
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void putValue(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value is null");
        }
        int bucketIndex = getBucketIndex(key);
        Bucket<K, V> head = this.buckets[bucketIndex];
        boolean flag = false;
        while (head != null && !flag) {
            if (head.getKey().equals(key)) {
                head.setValue(value);
                flag = true;
            }
            head = head.getNext();
        }
        if (!flag) {
            this.size++;
            head = buckets[bucketIndex];
            Bucket<K, V> node = new Bucket<>(key, value);
            node.setNext(head);
            buckets[bucketIndex] = node;
        }
    }

    public V getValue(K key) {
        if (key == null) {
            throw new IllegalArgumentException("The key is null");
        }
        int bucketIndex = getBucketIndex(key);
        V value = null;
        Bucket<K, V> head = buckets[bucketIndex];
        boolean found = false;
        while (head != null && !found) {
            if (head.getKey().equals(key)) {
                value = head.getValue();
                found = true;
            }
            head = head.getNext();
        }
        return value;
    }

    public V removeValue(K key) {
        if (key == null) {
            throw new IllegalArgumentException("The key is null");
        }
        int bucketIndex = getBucketIndex(key);
        V value = null;
        Bucket<K, V> head = buckets[bucketIndex];
        Bucket<K, V> previous = null;
        while (head != null) {
            if (head.getKey().equals(key)) {
                break;
            }
            previous = head;
            head = head.getNext();
        }
        if (head == null) {
            value = null;
        } else {
            this.size--;
            if (previous != null) {
                previous.setNext(head.getNext());
            } else {
                buckets[bucketIndex] = head.getNext(); // deleting the head (first element) of this hash bucket
            }
            value = head.getValue();
        }
        return value; // Implementar
    }
}
