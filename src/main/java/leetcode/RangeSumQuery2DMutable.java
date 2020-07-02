class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        mat = matrix;
    }
    
    public void update(int row, int col, int val) {
        mat[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=0;
        for(int i=row1; i<=row2; i++){
            for(int j=col1; j<=col2; j++){
                ans+=mat[i][j];
            }
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
