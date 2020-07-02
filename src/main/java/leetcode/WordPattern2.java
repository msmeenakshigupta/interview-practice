class Solution {
        public boolean wordPatternMatch(String pattern, String str) {
            Map<Character, String> mp = new HashMap<>();
            Map<String,Character> stp = new HashMap<>();
            return doDfs(pattern, str, mp, 0, 0,stp);
        }

        public boolean doDfs(String pattern, String str, Map<Character, String> mp, int pos, int patpos, Map<String, Character> stp){
            if(patpos>=pattern.length() && pos>=str.length()){
                return true;
            }else if(patpos>=pattern.length()){
                return false;
            }
            //if pattern already exists in the map
            String ch = mp.get(pattern.charAt(patpos));
            if(ch!=null){
                int end = ch.length();
                if(pos+end <= str.length() && str.substring(pos,pos+end).equals(ch)){
                    return doDfs(pattern,str,mp,pos+end,patpos+1,stp);
                }else{
                    return false;
                }
            }
            //if not try to find the pattern
            for(int i=1;i<=str.length()-pos;i++){
                String sub = str.substring(pos,pos+i);
                if(stp.containsKey(sub)){
                    if(!stp.get(sub).equals(pattern.charAt(patpos))){
                        continue;   
                    }
                }
                stp.put(sub, pattern.charAt(patpos));
                mp.put(pattern.charAt(patpos),sub);
                if(doDfs(pattern,str, mp, pos+i, patpos+1,stp)){
                    return true;
                }
                stp.remove(sub);
                mp.remove(pattern.charAt(patpos));
            }
            return false;
        }
    }
