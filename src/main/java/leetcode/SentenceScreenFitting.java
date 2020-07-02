class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int index = 0, len = s.length();
        for (int i = 0; i < rows; i++) {
            // index points to the char that starts the current row
            index += cols;
            if (s.charAt(index % len) == ' ') {
                index ++; // go to the next one; next one must be a non-empty character 
            } else {
                while (index > 0 && s.charAt((index - 1) % len) != ' ') {
                    index --;
                }
            }
        }
        return index / len;
        
    }
}
