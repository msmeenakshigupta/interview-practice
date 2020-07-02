class Solution {
   private class UnionFind {
        private int[] parents;
        private int[] ranks;

        public UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                ranks[i] = 0;
            }
        }
        
        public int Find(int u) {
            while (parents[u] != u) {
                parents[u] = parents[parents[u]];
                u = parents[u];
            }
            return u;
        }

        public boolean Union(int u, int v) {
            int parnetU = Find(u);
            int parnetV = Find(v);
            
            if (parnetU == parnetV){
                return false;
            }

            if (ranks[parnetV] > ranks[parnetU]){
                parents[parnetU] = parnetV;
            } else if (ranks[parnetU] > ranks[parnetV]){
                parents[parnetV] = parnetU;
            } else {
                parents[parnetV] = parnetU;
                ranks[parnetU]++;
            }

            return true;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> results = new ArrayList<Integer>();
        int result = 0;
        
        boolean[][] grid = new boolean[m][n];
        UnionFind ufs = new UnionFind(m*n);
        
        for(int[] p : positions){
            int i = p[0], j = p[1];
            result = check(grid, i, j, m, n, ufs, result);
            results.add(result);
        }
        
        return results;
    }
    
    private int check(boolean[][] grid, int i, int j, int m, int n, UnionFind ufs, int result){
        result = grid[i][j] ? result : result+1;
        grid[i][j] = true;

        int self = j*m+i;
        int left = j*m+i-1;
        int right = j*m+i+1;
        int up = (j-1)*m+i;
        int down = (j+1)*m+i;

        if(i-1 >= 0 && grid[i-1][j] == true){
            if(ufs.Union(self, left)){
                result--;
            }
        }

        if(i+1 < m && grid[i+1][j] == true){
            if(ufs.Union(self, right)){
                result--;
            }
        }

        if(j-1 >= 0 && grid[i][j-1] == true){
            if(ufs.Union(self, up)){
                result--;
            }
        }

        if(j+1 < n && grid[i][j+1] == true){
            if(ufs.Union(self, down)){
                result--;
            }
        }

        return result;
    }
}
