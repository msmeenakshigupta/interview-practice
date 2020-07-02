class Solution {
    
    
    public List<List<Integer>> getFactors(int n) {
      List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(n, curr, res, 2);
        return res;
    }
    public void helper(int n, List<Integer> curr, List<List<Integer>> res, int start){
        List<Integer> temp = new ArrayList<>(curr);
        if(temp.size()>0){
            temp.add(n);
            res.add(temp);
        }
        
        for(int i = start; i * i <= n; i++){
            if(n%i == 0){
                curr.add(i);
                helper(n/i, curr, res, i);
                curr.remove(curr.size()-1);
            }
        }
    
    }
}
