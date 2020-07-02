public class ZigzagIterator {
    List<Integer> l1;
    List<Integer> l2;
    int total;
    int loc=0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l1=v1;
        l2=v2;
        total = l1.size()+l2.size();
        
    }

    public int next() {
        if(hasNext()){
            int index=loc/2;
            if(index< l1.size() && index<l2.size()){
                total--;
                boolean first=true;
                if(loc%2==1){
                    first=false;
                }
                loc++;      
                if(!first){
                    return l2.get(index);
                }else{
                    return l1.get(index);
                }           
            }
            if(index>=l1.size()){
                index = loc-l1.size();
                total--;
                loc++;
                return l2.get(index);
            }
            if(index>=l2.size()){
                index = loc-l2.size();
                total--;
                loc++;
                return l1.get(index);
            }
        }
        
        return -1;
    }

    public boolean hasNext() {
        while(total>0)
            return true;
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
