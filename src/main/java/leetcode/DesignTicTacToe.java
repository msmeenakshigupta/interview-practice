class TicTacToe {
    
    int[][] grid;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        grid = new int[n][n];
        this.n=n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        grid[row][col] = player;
        if(isRow(row,col) || isCol(row,col) || isDiag(row,col)){
            return player;
        }
        
        return 0;
    }
    
    private boolean isRow(int r, int c){
        int val = grid[r][c];
        for(int i=0; i<n; i++){
            if(grid[r][i]!=val)
                return false;
        }
        return true;
    }
    
    private boolean isCol(int r, int c){
        int val = grid[r][c];
        for(int i=0; i<n; i++){
            if(grid[i][c]!=val)
                return false;
        }
        return true;
    }
    
    private boolean isDiag(int r, int c){
        
        return leftDiag(r,c) || rightDiag(r,c);
    }
    
    private boolean leftDiag(int r, int c){
        int val = grid[r][c];
        int i=0, j=0;
        while(i<n && j<n){
            if(grid[i][j]!=val)
                return false;
            i++;
            j++;
        }
        return true;
    }
    
    private boolean rightDiag(int r, int c){
        int val = grid[r][c];
        int i=0, j=n-1;
        while(i<n && j>=0){
            if(grid[i][j]!=val)
                return false;
            i++;
            j--;
        }
        return true;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
