class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
            
        Map<Integer, Set<Integer>> G=new HashMap<>();
        
        if(seqs==null || seqs.size()==0) return false;
        
        int N=org.length;
        
        for(List<Integer> seq:seqs){ // maintain dependency graph from i->i+1 in every sequence
            for(int i=0;i<seq.size();i++){
                G.putIfAbsent(seq.get(i), new HashSet<>());
                if(i < seq.size()-1) {
                    G.get(seq.get(i)).add(seq.get(i+1));
                }
            }
        }
        
        if(G.size()!=N) return false; // not correct count of vertices
        
        BitSet visited=new BitSet(N); // cycle detect
        for(int u=0;u<org.length;u++){
            visited.set(org[u]);
            Set<Integer> to=G.get(org[u]);
            if(to==null || (u<org.length-1 && !to.contains(org[u+1]))) {
                return false; // next vertex in ORG not found
            }
            for(int v:to) { // cycle check, any optimization?
                if(visited.get(v)) {
                    return false;   
                }
            }
        }
        
        return true;
    }
}
