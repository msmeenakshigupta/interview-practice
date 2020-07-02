class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
          if(s == null || s.length() == 0) return 0;
        // Sliding window approach
        int maxLength = 0;
         int low = -1;
        LinkedHashMap<Character,Integer> charLoc = new LinkedHashMap();
        
        for(int right = 0 ; right < s.length(); right++) // O(N)
        {
            charLoc.put(s.charAt(right),right);
            
            if(charLoc.size() > k){
                // get the minimum of all char indices   
                int index = getMinimum(new ArrayList<>(charLoc.values())); // O(k)
                charLoc.remove(s.charAt(index));
                low = index;
            }
            
            maxLength = Math.max(maxLength, right-low);
        }
      
        return maxLength; 
    }
    
    public int getMinimum(List<Integer> values)
    {
        int minimum = values.get(0);
        
        for(int value: values)
        {
            minimum = Math.min(minimum, value);
        }
        
        return minimum;
    }
}
