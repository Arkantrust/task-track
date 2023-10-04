package me.arkantrust.utils;

class Entry<K, V> {

    K key;
    V value;

    public Entry(K key, V value) {
    
        this.key = key;    
        this.value = value;
    
    }

}

public class HashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    public HashMap() {

        this(DEFAULT_CAPACITY);
    
    }

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
    
        this.buckets = (LinkedList<Entry<K, V>>[]) new LinkedList[capacity];
    
        for (int i = 0; i < capacity; i++) {
    
            buckets[i] = new LinkedList<>();
    
        }
    
    }

    public void put(K key, V value) {
    
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
    
            if (entry.key.equals(key)) {
    
                entry.value = value;
    
                return;
    
            }
    
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        bucket.add(newEntry);
    
    }

    public V get(K key) {
    
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
    
            if (entry.key.equals(key)) {
    
                return entry.value;
    
            }
    
        }

        return null;

    }

    private int getIndex(K key) {

        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;

    }

    public boolean isEmpty() {

        return buckets.length == 0;
    
    }

}
