class Solution {
    Set < String > set = new HashSet < > ();
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> chars = new HashMap();
        
        int ones =0;
        for(char c : s.toCharArray()){
            int count = chars.getOrDefault(c,0);
            if(count%2==0){
                ones++;
            }else{
                ones--;
            }
            chars.put(c, count+1);
            
        }
        List<String> res = new ArrayList();
        if(ones>1) //no possbile ans exists.
            return res;
       char[] st = new char[s.length()/2];
        int k=0;
        char ch = '0';
        for(Character c : chars.keySet()){
            int count = chars.get(c);
            
            if(count%2==1){
                ch = c;
                count--;
                
            }
            while(count!=0){
                st[k++] = c;
                count-=2;
            }    
            
                
        }
        permute(st, 0, ch);
        return new ArrayList<String>(set);
    }
    
    public void permute(char[] s, int l, char ch){
        if(l==s.length){
            set.add(new String(s) + (ch=='0' ? "" : ch) + new StringBuffer(new String(s)).reverse());
        }else{
            for(int i=l; i<s.length; i++){
                if(s[l]!=s[i] || l==i){
                    swap(s,l,i);
                    permute(s, l+1, ch);
                    swap(s,l,i);
                }
            }
        }
    }
    
    public void swap(char[] s, int i, int l){
        char temp = s[l];
        s[l] = s[i];
        s[i] = temp;
    }
}
