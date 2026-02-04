package com.example.kunal.systemdesign.designpatterns.singleton;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheManager {

    private Map<String, Object> cache = new ConcurrentHashMap<>();

    public void put(String key, Object value){
        cache.put(key, value);
    }

    public Object get(String key){
        return cache.get(key);
    }
}
