class CombinationSum {
    List<List<Integer>> result;
    int sum;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        sum = target;
        helper(new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    
    public void helper(List<Integer> list, int[] cand, int target, int index){
        if(target > 0){
            for(int i = index; i < cand.length && target >= cand[i]; i++){
                
    			list.add(cand[i]);
    			helper(list, cand, target - cand[i], i+1);
    			list.remove(list.size() - 1);
    		}        }
        else if(target == 0 && !result.contains(list)){
            result.add(new ArrayList<>(list));
        }
        
        
        ///if candidates array does not contain duplicates, we can remove check for list in the result in line 21
    }
}
