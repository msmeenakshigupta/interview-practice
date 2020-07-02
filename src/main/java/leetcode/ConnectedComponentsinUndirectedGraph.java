class Solution {
    public int countComponents(int n, int[][] edges) {
        
         //adjacent list
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        //construct graph
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            adj.get(src).add(dst);
            adj.get(dst).add(src);
        }
        
        //tracking information
        int[] explored = new int[n];
        int numberOfComponent = 0;
        
        for(int start = 0; start < n; start++){
            
            if(explored[start] == 0){
                
                numberOfComponent++;
                
                //DFS
                Stack<Integer> stack = new Stack<>();
                int[] exploredSet = new int[n];
                
                stack.push(start);
                
                while(!stack.isEmpty()){
                    
                    int cur = stack.pop();
                    
                    if(exploredSet[cur] == 0){
                        exploredSet[cur] = 1;
                        explored[cur] = 1;
                        
                        for(int i=0; i < adj.get(cur).size(); i++){
                            stack.push(adj.get(cur).get(i));
                        }
                    }
                }
            }
        }
        
        return numberOfComponent;
        
    }
}
