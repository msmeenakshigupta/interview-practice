class Solution {
    char[][] arr = new char[][]{{'6','9'},{'9','6'},{'0','0'},{'1','1'},{'8','8'}};
    
    public List<String> findStrobogrammatic(int n) {
        if(n == 0) return new ArrayList<>();
        
        List<String> res = new ArrayList<>();
        dfs(res, new char[n], 0, n-1);
        return res;
    }
    
    private void dfs(List<String> res, char[] num, int lo, int hi){
        if(hi < lo){
            res.add(new String(num));
            return;
        }
        
        if(lo == hi){
            for(char c: "018".toCharArray()){
                num[lo] = c;
                res.add(new String(num));
            }
            return;
        }
        
        for(char[] c: arr){
            if(lo == 0 && c[0] == '0') continue;
            
            num[lo] = c[0];
            num[hi] = c[1];
            dfs(res, num, lo+1, hi-1);
        }
    }
}
