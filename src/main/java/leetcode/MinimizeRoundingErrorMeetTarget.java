class Solution {
    public String minimizeError(String[] prices, int target) {
        int lowerSumLimit=0, upperSumLimit=0;
        int len=prices.length;
        CeilPriceWithDiff[] ceilPrices=new CeilPriceWithDiff[len];
        for(int i=0; i<len; i++){
            double p=Double.parseDouble(prices[i]);
            lowerSumLimit+=Math.floor(p);
            upperSumLimit+=Math.ceil(p);
            ceilPrices[i]=new CeilPriceWithDiff((int)Math.ceil(p), Math.ceil(p)-p);
        }
        if (target>upperSumLimit||target<lowerSumLimit) return "-1";
        
        Arrays.sort(ceilPrices, (p1, p2)->Double.compare(p2.diff, p1.diff));
        double roundingError=0.0;
        for(int i=0; i<ceilPrices.length; i++){
            if (upperSumLimit>target){
                roundingError+=(1.0-ceilPrices[i].diff);
                upperSumLimit--;
            }else{
                roundingError+=ceilPrices[i].diff;
            }
        }
        return String.format("%.3f", roundingError);
    }
    
    class CeilPriceWithDiff{
        int ceilPrice;
        double diff;
        public CeilPriceWithDiff(int ceilPrice, double diff){
            this.ceilPrice=ceilPrice;
            this.diff=diff;
        }
    }
}
