class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int ans=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='0')
                    ans = Math.max(ans, findEnemies(grid, i, j));
            }
        }
        return ans;
    }
    
    public int findEnemies(char[][] grid , int i, int j){
        return rowEnemies(grid,i, j)+ colEnemies(grid, i, j);
    }
    
    public int rowEnemies(char[][] grid,int r, int c){
        int ans=0;
        int cols = grid[0].length;
        int i=c;
        while(i>=0){
            if(grid[r][i]=='W')
                break;
            if(grid[r][i]=='E')
                ans++;
            i--;
        }
        i=c;
        while(i<cols){
             if(grid[r][i]=='W')
                break;
            if(grid[r][i]=='E')
                ans++;
            i++;
        }
        
        return ans;
        
    }
    
     public int colEnemies(char[][] grid,int r, int c){
        int ans=0;
        int rows = grid.length;
        int i=r;
        while(i>=0){
            if(grid[i][c]=='W')
                break;
            if(grid[i][c]=='E')
                ans++;
            i--;
        }
        i=r;
        while(i<rows){
             if(grid[i][c]=='W')
                break;
            if(grid[i][c]=='E')
                ans++;
            i++;
        }
        
        return ans;
        
    }
}
