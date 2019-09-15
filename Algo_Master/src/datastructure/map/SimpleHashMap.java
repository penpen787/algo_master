package datastructure.map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class SimpleHashMap<K, V> {

    private static final int INITIAL_BUCKET_SIZE = 100;

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

//    private int bucketSize; // todo : rehashing for balance
    private LinkedList<Entry>[] buckets = null;
    private int bucketSize;
    private int size;
    // initialize
    {
        bucketSize = INITIAL_BUCKET_SIZE;
        buckets = new LinkedList[bucketSize];
        size = 0;
    }

    public V get(K key) {
        if(key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int mod = key.hashCode() % bucketSize;
        LinkedList<Entry> bucket = buckets[mod];
        if(bucket == null) {
            return null;
        }
        for (Entry entry : bucket) {
            if(entry.key.equals(key)) {
                return (V) entry.value;
            }

        }
        return null;
    }

    public V put(K key, V value) {
        if(key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int mod = key.hashCode() % bucketSize;
        LinkedList<Entry> bucket = buckets[mod];
        if(bucket == null) {
            bucket = new LinkedList<>();
            bucket.add(new Entry(key, value));
            buckets[mod] = bucket;
            size++;
            return value;
        }

        for (Entry entry : bucket) {
            if(entry.key.equals(key)) {
                entry.value = value;
                return value;
            }
        }

        bucket.add(new Entry(key, value));
        size++;
        return value;
    }


    public V remove(Object key) {
        int mod = key.hashCode() % bucketSize;
        LinkedList<Entry> bucket = buckets[mod];
        Iterator<Entry> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if(entry.key.equals(key)) {
                iterator.remove();
                size--;
                return (V) entry.value;
            }
        }
        return null;
    }

    public void clear() {
        // remove pointer
        for(int i=0; i<buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for(LinkedList<Entry> bucket : buckets) {
            if(bucket != null) {
                for(Entry entry : bucket) {
                    keySet.add((K)entry.key);
                }
            }
        }
        return keySet;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
