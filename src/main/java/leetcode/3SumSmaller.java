class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] >= target) {
                break;
            } else if (nums[i] + nums[n - 1] + nums[n - 2] < target) {
                int l = n - i - 1;
                res += l * (l - 1) / 2;
                continue;
            }
            int k = n - 1;
            for (int j = i + 1; j < k; j++) {
                int s = nums[i] + nums[j] + nums[k];
                while (nums[i] + nums[j] + nums[k] >= target && k > j) {
                    k--;
                }
                
                int l = k - j + 1;
                res += l - 1;
            }
        }
        return res;
    }
}
