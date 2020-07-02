class Solution {
   
    
     HashMap<Character,Character> map = new HashMap<>();
    public Solution(){
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');
    }
    
    
    public boolean isStrobogrammatic(String num) {
       int left = 0, right = num.length() -1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);            
            
            if (map.containsKey(leftChar) && map.containsKey(rightChar)) { 
                if (map.get(leftChar) != rightChar || map.get(rightChar) != leftChar) return false;
            } else return false;
                                                      
            left++;
            right--;
        }
        
        return true;
    }
}
