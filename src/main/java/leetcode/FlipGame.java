class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList();
        
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
               StringBuilder aa = new StringBuilder();
                aa.append(s.substring(0,i));
                aa.append("--");
                aa.append(s.substring(i+2,s.length()));
                res.add(aa.toString());
            }
        }
        return res;
    }
   
}
