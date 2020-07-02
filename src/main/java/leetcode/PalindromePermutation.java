class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> chars = new HashMap();
        
        int ones =0;
        for(char c : s.toCharArray()){
            int count = chars.getOrDefault(c,0);
            if(count==0){
                chars.put(c,1);
                ones++;
            }else{
                chars.remove(c);
                ones--;
            }
            
        }
        if(ones==0 || ones==1)
            return true;
        return false;
    }
}
