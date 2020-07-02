class ValidWordAbbr {
   
    Map<String, String> abbrMap = new HashMap();
    public ValidWordAbbr(String[] dictionary) {
        for(String str : dictionary){
            
            String abbr="";
            if(str.length()<=2)
                abbr = str;
            else{
                int len  = str.length();
                abbr = str.charAt(0)+String.valueOf(len-2)+str.charAt(len-1);
            }
            if(abbrMap.containsKey(abbr)){
                String exist = abbrMap.get(abbr);
                if(!str.equals(exist))
                    abbrMap.put(abbr, null);
            }else{
                abbrMap.put(abbr, str);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String abbr;
        if(word.length()<=2)
            abbr = word;
        else{
            int len  = word.length();
            abbr = word.charAt(0)+String.valueOf(len-2)+word.charAt(len-1);
        }
       
        if(abbrMap.containsKey(abbr)){
            String str = abbrMap.get(abbr);
            if(str==null)
                return false;
            if(str.equals(word))
                return true;
            else 
                return false;
        }
        return true;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
