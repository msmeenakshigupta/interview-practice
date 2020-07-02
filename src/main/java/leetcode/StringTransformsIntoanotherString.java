class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        HashMap<Character, Character> map = new HashMap();
        for (int i=0;i<str1.length();i++) {
            char curr = str1.charAt(i);
            if (map.containsKey(curr)) {
                if (map.get(curr) != str2.charAt(i)) {
                    return false;
                }
            }
            else {
                map.put(curr, str2.charAt(i));
            }
        }
        if (new HashSet<>(map.values()).size() == 26) {
            return false;
        } 
        return true;
    }
}
