class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==1)
            return 1;
        Map<Integer, Integer> map = new HashMap();
        int before=0;
       
        int lastZero=-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                if(lastZero>=0){
                    int count = map.get(lastZero);
                    map.put(lastZero, count+before);
                }
                map.put(i,before);
                lastZero=i;
                before=0;
            }else{
                before++;
            }
        }
        if(lastZero>=0){
                    int count = map.get(lastZero);
                    map.put(lastZero, count+before);
                }
        int max = Integer.MIN_VALUE;
        for(int key: map.keySet()){
            max = Math.max(max, map.get(key));
        }
        if(lastZero==-1)
            return nums.length;
        return max+1;
    }
}
