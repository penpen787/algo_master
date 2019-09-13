package datastructure.map;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V> {

    private static final int INITIAL_BUCKET_SIZE = 100;

    private static class Entry<K, V> {
        K key;
        V value;
    }

//    private int bucketSize;
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
        // TODO : from here

//        bucket
        return null;
    }

    public V put(K key, V value) {
        if(key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }


        return null;
    }


    public V remove(Object key) {
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

    }

    public void clear() {

    }

    public Set<K> keySet() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    public boolean containsValue(Object value) {
        // TODO
        return false;
    }
    */

}
