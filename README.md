# LruCache

# LRU Cache in Java with Design Patterns


Singleton Pattern – Ensures a single instance of the cache.
Command Pattern – Used for eviction logic. which ever eviction we chose, same commands will be called.
Factory Pattern – Creates different storage implementations (in-memory, disk).
Strategy Pattern – To choose which eviction policy we need.

LRUCache<K, V>
- Singleton wrapper for the cache.
- For storage related logic we rely on CacheStorage implementation.

CacheStorage<K, V> *(Interface)
- interface for cache storage.
- Implementations: InMemoryCacheStorage<K, V>

 EvictionCommand<K, V> *(Interface)*
- interface eviction logic.
- Implementation: RemoveEldestCommand<K, V> - evicts the least recently used item when size exceeds capacity.

CacheEvictor<K, V>
- Executes the eviction command.

CacheStorageFactory
- Factory to create appropriate CacheStorage type ('IN_MEMORY', 'DISK','FILE').


