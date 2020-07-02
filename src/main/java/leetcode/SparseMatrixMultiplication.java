class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] ans = new int[A.length][B[0].length];
        for(int row = 0; row < A.length ; row ++){      
           for(int col = 0 ; col < B[0].length ; col++){
                int total = 0;
                for(int k = 0 ; k < B.length ; k++){
                    total = total + A[row][k] * B[k][col];
                }    
               ans[row][col] = total;
            }
            
        }
        return ans;
    }
}
