/**
 * created by megupta on 04/05/20
 */
public class HighestRobbery {

    public static void main(String[] args) {
        int[] nums = {1,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int max = 0;
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n==1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = Math.max(nums[nums.length-2], nums[nums.length-1]);
        for(int i = nums.length - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }

        return dp[0];
    }
}
