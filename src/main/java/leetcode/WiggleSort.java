class Solution {
    public void wiggleSort(int[] nums) {
        int i=0; 
        int n = nums.length;
        while(i<n-1){
            if(i%2==0){
                if(nums[i]>nums[i+1]){
                     makeSmall(i, nums);
                    i--;
                }
                   
            }else{
                if(nums[i]<nums[i+1]){
                     makeBig(i, nums);
                    i--;
                }
                   
            }
            i++;
        }
        
    }
    
    public void makeSmall(int i, int[] nums){
        int n = nums.length;
        int j =i+1;
        while(j<n-1 && nums[j]<nums[i]){
            j++;
        }
        relocate(nums, i, j);
        
    }
    
    public void makeBig(int i, int[] nums){
        int n = nums.length;
        int j = i+1;
        while(j<n-1 && nums[j]>nums[i]){
            j++;
        }
        relocate(nums,i,j);
        
    }
    
    public void relocate(int[] nums, int i, int j){
        int n=nums.length;
        if(i<n && j<n){
            int temp = nums[i];
            while(i<j){
                nums[i] = nums[i+1];
                i++;
            }
           
            nums[j] = temp;
        }
        
    }
}
