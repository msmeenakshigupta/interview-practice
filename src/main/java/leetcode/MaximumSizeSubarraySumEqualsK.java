class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans =0;
        if(nums.length==0)
            return ans;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i] = nums[i]+sum[i-1];
        }
        for(int i=nums.length-1; i>=0; i--){
            if(sum[i]==k)
                ans = Math.max(ans, i+1);
        }
        
        for(int i=0; i<sum.length; i++){
            int s = nums[i];
            if(s==k){
                ans  = Math.max(ans, 1);
            }
            for(int j=i+1; j<sum.length; j++){
                s+=nums[j];
                if(s==k){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        
       return ans;
    }
}
