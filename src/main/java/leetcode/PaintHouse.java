class Solution {

   
    public int minCost(int[][] costs) {
        
        if(costs.length==0)
            return 0;
        
   
        int i=costs.length;
        for(int n=1; n<costs.length; n++){
            costs[n][0]+=Math.min(costs[n-1][1], costs[n-1][2]);
            costs[n][1]+=Math.min(costs[n-1][0], costs[n-1][2]);
            costs[n][2]+=Math.min(costs[n-1][0], costs[n-1][1]);
        }
        return Math.min(Math.min(costs[i-1][0], costs[i-1][1]), costs[i-1][2]);
    }
}
