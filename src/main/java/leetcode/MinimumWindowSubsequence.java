class Solution {
    public String minWindow(String S, String T) {
       if(T.length()==0) return "";
        String result="";
        for(int i=0;i<S.length()-T.length();i++){
            for(char t:T.toCharArray()){
                i=S.indexOf(t,i);
                if(i++==-1) return result;
            }
            i--;
            int end = i;
            for(int j =T.length()-1;j>=0;j--){
                i=S.lastIndexOf(T.charAt(j),i)-1; 
            }
            i++;
            if( result.length()>end-i+1 || result.isEmpty()){
                result = S.substring(i,end+1);
            }
        }
        return result;
    }
        
}
