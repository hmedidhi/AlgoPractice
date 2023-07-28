package com.practice.ds.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache_JAVALIB {
    private int capacity = 0;
    private final HashMap<Integer, Integer> map;
    private final LinkedList<Integer> cache;

    public LRUCache_JAVALIB(int capacity) {
        map = new HashMap<>(capacity);
        cache = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            cache.remove((Integer) key);
            cache.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            cache.remove((Integer) key);
            map.put(key, value);
        } else if (capacity > 0) {
            map.put(key, value);
            capacity--;
        } else {
            map.remove(cache.removeFirst());
            map.put(key,value);
        }
        cache.addLast(key);
    }
}
