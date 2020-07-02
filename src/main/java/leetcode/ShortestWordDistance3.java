class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> l1 = new ArrayList();
        List<Integer> l2 = new ArrayList();
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            
            if(words[i].equals(word1))
               l1.add(i);
           
            if(words[i].equals(word2))
                l2.add(i);
            
        }
        int i=0, j=0;
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)==l2.get(j))
                i++;
            else{
                int diff = Math.min(ans, Math.abs(l1.get(i)-l2.get(j)));
                if(diff>0)
                    ans = diff;
                if(l1.get(i)<l2.get(j))
                    i++;
                else
                    j++;
            }
        }
        return ans;
    }
}
