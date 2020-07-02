class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
       int n= nums.length;
        List<String> list=new ArrayList<>();
        
        //If input array is empty. Put something and return it;
        if(n==0){
            if(lower==upper){
                list.add(lower+"");
            }
            else{
                list.add(lower+"->"+upper);
            }
            return list;
        }
        
        //Checking the Lower limit before starting the loop
        if(nums[0]!=lower){
            if(lower+1==nums[0]) list.add(lower+"");
            else list.add(lower+"->"+(nums[0]-1));
        }
        
        //setting inner requirements.
        for(int i=0;i<n-1;i++){
            if((nums[i]==nums[i+1]-1)||nums[i]==nums[i+1])continue;
            else{
                int t1 = nums[i]+1;
                int t2 = nums[i+1]-1;
                if(t1==t2){
                    list.add(t1+"");
                }
                else{
                    list.add(t1+"->"+t2);
                }
            }
        }
        //checking the upper limit.
        if(nums[n-1]!=upper){
            if(upper==nums[n-1]+1) list.add(upper+"");
            else list.add((nums[n-1]+1)+"->"+upper);
        }
        //final return :)
        return list;
    }
}
