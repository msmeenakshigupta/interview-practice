/**
 * created by megupta on 03/05/20
 */
public class MaxSubarr {

    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int sum=nums[0];

        for(int i=0;i<nums.length;i++){
            int current_sum = nums[i];
            sum=Math.max(sum,current_sum);
            for(int j=i-1;j>=0;j--){
                current_sum+=nums[j];
                sum=Math.max(sum,current_sum);
            }


        }

        return sum;
    }
}
