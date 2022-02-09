package com.geekcircle.Java.SystemDesign.MultiLevelCaching;

import java.util.LinkedHashMap;
import java.util.Map;

public class L1Cache extends Cache {

    Map<String, String> cache;

    private int capacity;
    private Long readTime;
    private Long writeTime;

    public L1Cache(int capacity) {
        this(null, capacity);
    }

    public L1Cache(Cache nextLevel, int capacity) {
        super(nextLevel, 1L);
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(this.capacity);
    }

    String getKey(String key){
        String value = null;
        if(cache.containsKey(key)){
            value = leastRecentlyViewed(key);
            if(value == null && super.getNextLevel() != null){
                value = super.getNextLevel().getKey(key);
            }
        }
        return value;
    }

    Boolean setKey(String key, String value){
        Boolean saved = false;
        if(!this.isKeyExist(key)){
            this.evict(key);
            cache.put(key, value);
            saved = true;
            if(this.getNextLevel() != null && !this.getNextLevel().isKeyExist(key)){
                saved = this.getNextLevel().setKey(key, value);
            }
        } else {
            leastRecentlyViewed(key);
        }
        return saved;
    }

    boolean isKeyExist(String key){
        if(cache.containsKey(key)){
            return true;
        }
        return false;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Long getReadTime() {
        return this.readTime;
    }

    public Long getWriteTime() {
        return this.writeTime;
    }

    public void evict(String key){
        if(this.capacity == cache.size()){
            Map.Entry<String, String> entry = cache.entrySet().iterator().next();
            cache.remove(entry.getKey());
        }
    }

    private String leastRecentlyViewed(String key){
        String value = cache.get(key);
        cache.remove(key);
        return cache.put(key, value);
    }
}
