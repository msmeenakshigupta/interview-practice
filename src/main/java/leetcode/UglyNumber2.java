class Solution {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0]= 1;
        int i=0, j=0,k=0;
        for(int counter =1; counter<n; counter++){
            int mul2 = result[i]*2;
            int mul3 = result[j]*3;
            int mul5 = result[k]*5;
            int min = Math.min(mul2, Math.min(mul3, mul5));
            result[counter] = min;
            if(min==mul2)
                i++;
            if(min==mul3)
                j++;
            if(min==mul5)
                k++;
            
        }
        return result[n-1];
        
    }
}
