class Solution {  
    // Binary Search is good when we want to guess the solution and shrink the range to get precise value.
    // result should range from [min, max] in the array.
    // for a random number, how do we know if there exist a sum larger than current number?
    // (nums[i]+nums[i+1]+...+nums[j])/(j-i+1)>x
    // =>nums[i]+nums[i+1]+...+nums[j]>x*(j-i+1)
    // =>(nums[i]-x)+(nums[i+1]-x)+...+(nums[j]-x)>0
    public double findMaxAverage(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a : nums) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        double l = min, r = max;
        while (l + 0.00001 < r) {
            double mid = (l + r) / 2;
            if (canFindLargerAverage(mid, nums, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
    // Similar to Sliding Window technique, for first k elements, we get the cumulative sum among them, cur. If it is smaller than 0, we slide the window. Attention that, prefixSum keeps track of cumulative sum in front of the current window. If prefixSum is smaller than 0, the cumulative sum of current window, which equals to cur - prefixSum, becomes bigger, i.e., is more possible to >= 0.
    public boolean canFindLargerAverage(double target, int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - target;
        }
        if (sum >= 0) {
            return true;
        }
        // find whether there is a subarray with length >= k whose sum is bigger than 0
        double prefixSum = 0;
        for (int i = k; i < n; i++) {
            prefixSum += nums[i - k] - target;
            sum += nums[i] - target;
            if (prefixSum < 0) {
                sum -= prefixSum;
                prefixSum = 0;
            }
            if (sum >= 0) {
                return true;
            }
        }
        return false;  
    }
}
