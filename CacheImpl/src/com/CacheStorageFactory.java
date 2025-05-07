package com;

import interfaces.CacheStorage;
import interfaces.EvictionCommand;

public class CacheStorageFactory {
    public enum StorageType {
        IN_MEMORY, DISK
    }

    public static <K, V> CacheStorage<K, V> create(StorageType type, int capacity) {
        EvictionCommand<K, V> eviction = new RemoveEldestKey<>(capacity);

        switch (type) {
            case IN_MEMORY:
            default:
                return new InMemoryCacheStorage<>(capacity, eviction);
        }
    }
}

