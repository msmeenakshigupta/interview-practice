class Solution {
    public boolean validWordSquare(List<String> words) {
        int rows = words.size();
        
        char[][] grid = new char[rows][];
        for(int i=0; i<rows; i++){
            String word = words.get(i);
            grid[i] = word.toCharArray();
        }
        for(int i=0; i<rows; i++){
            String row = words.get(i);
            String col = getWordInCol(grid, i);
            if(!row.equals(col))
                return false;
        }
        
        return true;
    }
    
    public String getWordInCol(char[][] grid, int c){
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<grid.length; i++){
            if(grid[i].length>c){
                sb.append(grid[i][c]);
            }
        }
        return sb.toString();
    }
}
