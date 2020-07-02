class Solution {
    public int shortestWay(String source, String target) {
        
       
        
        int i=0, count=0;
        while(i<target.length()){
            int j=0;
            int prev = i;
            while(j<source.length()){
                if(source.charAt(j)==target.charAt(i)){
                    i++;
                    j++;
                }else{
                    j++;
                }
                if(i==target.length())
                    break;
            }
            if(prev==i){// no match found in above loop
                return -1;
            }
            count++;
        }
        return count;
    }
}
