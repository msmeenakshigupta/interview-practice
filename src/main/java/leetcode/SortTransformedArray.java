class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i=0; i<nums.length; i++){
        
            int val = nums[i];
            pq.add(a*val*val+b*val+c);
        }
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
