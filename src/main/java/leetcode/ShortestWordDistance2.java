class WordDistance {
    Map<String, List<Integer>> wordsMap;
    public WordDistance(String[] words) {
        wordsMap  = new HashMap();
        for(int i=0; i<words.length; i++){
            List<Integer> a = wordsMap.getOrDefault(words[i], new LinkedList());
            a.add(i);
            wordsMap.put(words[i], a);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = wordsMap.get(word1);
        List<Integer> l2 = wordsMap.get(word2);
        int i=0, j=0;
        int dis = Integer.MAX_VALUE;
        while(i<l1.size() && j<l2.size()){
            int diff =Math.abs( l1.get(i)-l2.get(j));
            dis = Math.min(diff, dis);
            if(l1.get(i)<l2.get(j))
                i++;
            else if(l1.get(i)>l2.get(j))
                j++;
            else 
                return 0;
        }
        return dis;
       
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
