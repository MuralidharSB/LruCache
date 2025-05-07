package interfaces;

import java.util.LinkedHashMap;

public interface EvictionCommand<K, V> {
    void evict(LinkedHashMap<K, V> map);
}

