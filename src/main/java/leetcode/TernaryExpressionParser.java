class Solution {
    public String parseTernary(String expression) {
        if(expression.length()<5)
            return "";
        
        String ans =null;
        while(expression.indexOf('?')>-1){
            int i = expression.lastIndexOf('?');
            int j = expression.indexOf(':', i);
            String condition = expression.substring(i-1, i);
            String truth = expression.substring(i+1,j);
            String otherwise = expression.substring(j+1, j+2);
            if(condition.equals("T")){
                ans = truth;
            }else{
                ans = otherwise;
            }
            expression = expression.substring(0,i-1)+ans+expression.substring(j+2);
        }
        return ans;
    }
}
