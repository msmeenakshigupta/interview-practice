class AutocompleteSystem {
    Map<String, Integer> sentencesMap = new HashMap();
    String line="";
    public AutocompleteSystem(String[] sentences, int[] times) {
       for(int i=0; i<sentences.length; i++){
           sentencesMap.put(sentences[i], times[i]);
       } 
        
        
    }
    
    public List<String> input(char c) {
         List<String> out = new ArrayList<String>();
        if(c=='#'){
            sentencesMap.put(line, sentencesMap.getOrDefault(line,0)+1);
            line = "";
        }else{
            line+=c;
            List<Popular> list = new LinkedList();
           for(String key:sentencesMap.keySet() ){
               if(key.indexOf(line)==0)
                    list.add(new Popular(key, sentencesMap.get(key)));
           }
            Collections.sort(list, (a,b) -> a.times==b.times? a.line.compareTo(b.line) : b.times-a.times);
            for(int i=0; i<Math.min(3, list.size()); i++){
                out.add(list.get(i).line);
            }
            
        }
       
        return out;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

class Popular{
    String line;
    int times;
    
    public Popular(String sentence, int time){
        this.line = sentence;
        this.times = time;
    }
    
    public String toString(){
        return line;
    }
}
