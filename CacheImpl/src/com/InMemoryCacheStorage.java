package com;

import java.util.LinkedHashMap;
import java.util.Map;

import interfaces.CacheStorage;
import interfaces.EvictionCommand;

public class InMemoryCacheStorage<K, V> implements CacheStorage<K, V> {
    private final LinkedHashMap<K, V> map;
    private final CacheEvictor<K, V> evictor;

    public InMemoryCacheStorage(int capacity, EvictionCommand<K, V> evictionCommand) {
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.evictor = new CacheEvictor<>();
        this.evictor.setCommand(evictionCommand);
    }

    @Override
    public synchronized void put(K key, V value) {
        map.put(key, value);
        evictor.execute(map);
    }

    @Override
    public synchronized V get(K key) {
        return map.get(key);
    }

    @Override
    public void printCache() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}

