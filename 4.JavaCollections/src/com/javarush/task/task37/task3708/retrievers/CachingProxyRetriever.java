package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    OriginalRetriever originalRetriever;
    LRUCache<Long, Object> lruCache= new LRUCache<>(10);


    @Override
    public Object retrieve(long id) {
        Object result = lruCache.find(id);
        if (result == null) {
            Object o = originalRetriever.retrieve(id);
            lruCache.set(id, o);
            return o;
        }
        System.out.println("Returning cached object!");
        return result;
    }

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }
}
