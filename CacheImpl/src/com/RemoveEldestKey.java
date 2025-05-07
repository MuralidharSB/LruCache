package com;

import java.util.LinkedHashMap;

import interfaces.EvictionCommand;

public class RemoveEldestKey<K, V> implements EvictionCommand<K, V> {
    private final int maxSize;

    public RemoveEldestKey(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void evict(LinkedHashMap<K, V> map) {
        if (map.size() > maxSize) {
            K eldestKey = map.keySet().iterator().next();
            map.remove(eldestKey);
        }
    }
}
