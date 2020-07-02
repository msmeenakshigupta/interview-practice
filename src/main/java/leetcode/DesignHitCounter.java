class HitCounter {

    Map<Integer, Integer> counterMap;
    /** Initialize your data structure here. */
    public HitCounter() {
        counterMap = new HashMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int count = counterMap.getOrDefault(timestamp,0);
        counterMap.put(timestamp, count+1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int min = timestamp-300;
        int ans = 0;
        for(Integer time : counterMap.keySet()){
            if(time>min){
                ans+=counterMap.get(time);
            }
        }
        return ans;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
