class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
       if (word == null || word.isEmpty() || abbr == null || abbr.isEmpty()) return false;

        int i = 0; int j = 0, number = 0;
        while (i < word.length() && j < abbr.length()) {
            if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                number = number * 10 + abbr.charAt(j) - '0';
                if (number == 0) return false;
                j++;
            } else {
                i += number;
                number = 0;
                if (i >= word.length() || word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }
        i += number;
        return i == word.length() && j == abbr.length();
    }
}
