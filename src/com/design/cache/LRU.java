package com.design.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

    private final Map<Integer, Integer> cache;

    int maxSize;

    public LRU(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 100.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }


    public static void main(String[] args) {
        LRU solution = new LRU(2);
        solution.set(1, 10);
        solution.set(5, 12);
        solution.get(5);
        solution.get(1);
        solution.get(10);
        solution.set(6, 14);
        System.out.println(solution.get(5));
    }
}
