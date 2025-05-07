package interfaces;

public interface CacheStorage<K, V> {
    void put(K key, V value);
    V get(K key);
    void printCache();
}

