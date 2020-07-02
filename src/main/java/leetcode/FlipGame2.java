class Solution {
    
    public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap();
        return dfs(s, map);
    }
    
    public boolean dfs(String s, Map<String, Boolean> map ) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i=0;i<s.length()-1;i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                StringBuilder newSb = sb.replace(i,i+2, "--");
                if (!dfs(newSb.toString() , map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
