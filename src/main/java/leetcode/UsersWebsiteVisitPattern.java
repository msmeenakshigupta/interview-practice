class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
   // orgainze data in <name, <time, page>> sorted by time
    Map<String, TreeMap<Integer, String>> data = new HashMap();
    for(int i=0; i< username.length; i++){
      data.putIfAbsent(username[i], new TreeMap());
      data.get(username[i]).put(timestamp[i], website[i]);
    }

    Map<String, Integer> counter = new HashMap();

    for(TreeMap<Integer, String> visited: data.values() ){
      List<String> sites = new ArrayList(visited.values());
	  //generate all possible 3 sequent visit list and do count, use set since we are counting by users
      Set<String> seqList = all3seq(sites);
      for(String seq: seqList){
        counter.put(seq, counter.getOrDefault(seq, 0)+1);
      }
    }
	//one loop to find max
    int max = 0;
    String rslt =null;
    for(String seq: counter.keySet()){
      int cnt = counter.get(seq);
      if(cnt > max){
        rslt = seq;
        max = cnt;
      }else if(cnt == max){
        if(seq.compareTo(rslt) <0) rslt = seq;
      }
    }
    List<String> output = Arrays.asList(rslt.split(" "));
    return output;
  }

  Set<String> all3seq(List<String> sites){
    Set<String> rslt = new HashSet<>();

    List<List<String>> lists = new ArrayList();
    helper(sites, 0, new ArrayList(), lists);
    for(List<String> list: lists){
      StringBuilder sb = new StringBuilder();
      for(String s: list){
        sb.append(s).append(" ");
      }
      sb.deleteCharAt(sb.length()-1);
      rslt.add(sb.toString());
    }
    return rslt;
  }

  void helper(List<String> sites, int start, List<String> list,  List<List<String>> rslt){
    if(list.size() == 3){
      rslt.add(new ArrayList(list));
      return;
    }

    for(int i= start; i< sites.size(); i++){
      String site = sites.get(i);
      list.add(site);
      helper(sites, i+1, list,  rslt);
      list.remove(list.size()-1);
    }
  }
}
