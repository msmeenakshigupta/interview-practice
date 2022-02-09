package com.geekcircle.Java.SystemDesign.MultiLevelCaching;

public class CacheSystem {

    private static Cache initializer(){
        Cache level2Cache = new L1Cache(5);
        Cache level1Cache = new L1Cache(level2Cache, 3);
        return level1Cache;
    }

    public static void main(String[] args) {
        Cache cache = CacheSystem.initializer();
        cache.setKey("Akshay", "Singhai");
        cache.setKey("Nehal", "Jain");
        cache.setKey("Akash", "Sharma");
        cache.setKey("Akshay", "Singhai");
        cache.getKey("Nehal");
        cache.setKey("Rahul", "Yadav");
        System.out.println(cache.getKey("Akshay"));
    }

}
