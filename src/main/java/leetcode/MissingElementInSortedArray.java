class Solution {
    public int missingElement(int[] nums, int k) {
        int start = nums[0];
        int target = start+k;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<=target)
                target++;
            else
                break;
        }
        return target;
    }
}
