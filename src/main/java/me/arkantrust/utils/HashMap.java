package me.arkantrust.utils;

import java.util.NoSuchElementException;

import lombok.Data;
import lombok.NonNull;

@Data
class Bucket<K, V> {

    private K key;
    private V value;
    private Bucket<K, V> next;

    public Bucket(K key, V value) {

        this.key = key;
        this.value = value;
        this.next = null;

    }

}

@Data
public class HashMap<K, V> {

    private Bucket<K, V>[] buckets;
    private int bucketsCount; // capacity of HashTable
    private int size; // number of values stored
    private static final int DEFAULT_CAPACITY = 10;

    public HashMap() {

        this(DEFAULT_CAPACITY);

    }

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {

        this.bucketsCount = capacity;
        buckets = new Bucket[capacity];
        this.size = 0;

    }

    private int getBucketOf(K key) {

        int hashCode = key.hashCode();

        // Temporary function
        // TODO: Investigate linear probing
        return Math.abs(hashCode) % bucketsCount;

    }

    public Boolean isEmpty() {

        return size == 0;

    }

    public void put(@NonNull K key, @NonNull V value) {

        int bucketIndex = getBucketOf(key);
        Bucket<K, V> head = this.buckets[bucketIndex];

        // if the key already exists, update the value
        boolean found = false;
        while (head != null && !found) {

            if (head.getKey().equals(key)) {

                head.setValue(value);
                found = true;

            }

            head = head.getNext();

        }

        // if the key doesn't exist, add it
        if (!found) {

            this.size++;
            head = buckets[bucketIndex];
            Bucket<K, V> node = new Bucket<>(key, value);
            node.setNext(head);
            buckets[bucketIndex] = node;

        }

    }

    public V get(@NonNull K key) {

        Bucket<K, V> head = buckets[getBucketOf(key)];

        while (head != null) {

            if (head.getKey().equals(key)) {

                return head.getValue();

            }

            head = head.getNext();

        }

        throw new NoSuchElementException("There is no value associated with " + key);
    }

    public V remove(@NonNull K key) {

        int bucketIndex = getBucketOf(key);
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

                previous.setNext(head.getNext()); // Replace nodes

            } else {

                buckets[bucketIndex] = head.getNext(); // deleting the head (first element) of this hash bucket

            }

            value = head.getValue();

        }

        return value; // TODO: Implementar???? @NicolasC101

    }

}
