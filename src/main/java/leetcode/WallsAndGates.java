class Solution {
  
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> directions = Arrays.asList(
                                new int[] { 1,  0},
                                new int[] {-1,  0},
                                new int[] { 0,  1},
                                new int[] { 0, -1}
                        );
        
        int rows = rooms.length;
        if(rows==0)
            return;
        int cols = rooms[0].length;
        
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j]==0){
                    q.add(new int[] {i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] point = q.poll();
            int r=point[0];
            int c=point[1];
            for(int[] d : directions){
                int row = r+d[0];
                int col = c+d[1];
                if(row<0 || col<0 || row>=rows || col>=cols || rooms[row][col]!=Integer.MAX_VALUE){
                    continue;
                }
                    
                
                rooms[row][col] = rooms[r][c]+1;
                q.add(new int[] {row,col});
            }
        }
        
    }
    
   
}
