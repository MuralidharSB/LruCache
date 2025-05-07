package com;

import interfaces.CacheStorage;

public class LRUCache<K, V> {
    private static LRUCache<?, ?> instance;
    private final CacheStorage<K, V> storage;

    @SuppressWarnings("unchecked")
    public static synchronized <K, V> LRUCache<K, V> getInstance(int capacity, CacheStorageFactory.StorageType type) {
        if (instance == null) {
            CacheStorage<K, V> storage = CacheStorageFactory.create(type, capacity);
            instance = new LRUCache<>(storage);
        }
        return (LRUCache<K, V>) instance;
    }

    private LRUCache(CacheStorage<K, V> storage) {
        this.storage = storage;
    }

    public void put(K key, V value) {
        storage.put(key, value);
    }

    public V get(K key) {
        return storage.get(key);
    }

    public void printCache() {
        storage.printCache();
    }
}

