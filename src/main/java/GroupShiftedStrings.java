class Solution {
    List<List<String>> ans = new ArrayList();
    String seq = "abcdefghijklmnopqrstuvwxyz";
    public List<List<String>> groupStrings(String[] strings) {
       
        
        Map<Integer, List<String>> map = new HashMap();
        for(String str : strings){
            int len  = str.length();
            List<String> list = map.getOrDefault(len, new ArrayList());
            list.add(str);
            map.put(len, list);
        }
        for(Integer key : map.keySet()){
            if(key==1)
                ans.add(map.get(key));
            else{
                List<String> list = map.get(key);
                findSequence(list);   
                
            }
        }
        return ans;
    }
    
    public void findSequence(List<String> list ){
         if(list.size()==1)
            ans.add(list);
        else{
            String s = list.get(0);
            List<Integer> toRemove = new ArrayList();
            for(int i=1; i<list.size(); i++){
                String t = list.get(i);
                if(!sameSequence(s,t))
                    toRemove.add(i);
            }
            if(toRemove.size()==0)
                ans.add(list);
            else{
                List<String> toAdd = new ArrayList();
                List<String> newList = new ArrayList();
                for(int i=0; i<list.size(); i++){
                    if(toRemove.contains(i))
                        newList.add(list.get(i));
                    else
                        toAdd.add(list.get(i));
                }
                ans.add(toAdd);
                findSequence(newList);
            }
        }
    }
    
    public boolean sameSequence(String s, String t){
        int len=s.length();
        int sIndex = seq.indexOf(s.charAt(0));
        int tIndex = seq.indexOf(t.charAt(0));
        int diff = sIndex-tIndex;
        for(int i=1; i<len; i++){
            sIndex = seq.indexOf(s.charAt(i));
            tIndex = seq.indexOf(t.charAt(i));
            int dis = sIndex-tIndex;
            if(dis==diff || (diff+26==dis) || (dis+26==diff))
                continue;
            else
                return false;
        }
        return true;
    }
}
