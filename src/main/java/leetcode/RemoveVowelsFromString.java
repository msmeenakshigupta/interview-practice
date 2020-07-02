class Solution {
    public String removeVowels(String S) {
        List<Character> vowels = new ArrayList();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(!vowels.contains(c))
                sb.append(c);
        }
        return sb.toString();
    }
    
}
