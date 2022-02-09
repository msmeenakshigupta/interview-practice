package com.geekcircle.Java.SystemDesign.MultiLevelCaching;

public abstract class Cache {

    private Cache nextLevel;
    private Long level;

    public Cache(Cache nextLevel, Long level) {
        this.level = level;
        this.nextLevel = nextLevel;
    }

    public Cache getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Cache nextLevel) {
        this.nextLevel = nextLevel;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    abstract String getKey(String key);

    abstract Boolean setKey(String key, String value);

    abstract boolean isKeyExist(String key);
}
