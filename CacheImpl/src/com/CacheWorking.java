package com;

public class CacheWorking {
    public static void main(String[] args) {
        
        LRUCache<Integer, String> diskCache = LRUCache.getInstance(3, CacheStorageFactory.StorageType.IN_MEMORY);

        diskCache.put(1, "Murali");
        diskCache.put(2, "Srivatsav");
        diskCache.put(3, "Hyd");
        diskCache.get(1);            
        diskCache.put(4, "Tg");   

        diskCache.printCache();      
    }
}

