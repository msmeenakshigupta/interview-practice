class Solution {
    public String nextClosestTime(String time) {
        Set<Character> allowed = new HashSet();
        for(char c: time.toCharArray()){
            if(c!=':')
                allowed.add(c);
        }
        int curr = Integer.valueOf(time.substring(0,2))*60+Integer.valueOf(time.substring(3));
        while(true){
            if(curr==1439)
                curr = 0;
            else
                curr++;
            String next = findTime(curr);
            if(isAllowed(next, allowed))
                return next;
        }  
        
        
    }
    
    public boolean isAllowed(String time, Set allowed){
        for(char c: time.toCharArray()){
            if(c!=':'){
                if(!allowed.contains(c))
                    return false;
            }
        }
        return true;
    }
    
    public String findTime(int minutes){
        int hour = minutes/60;
        int min = minutes%60;
        StringBuilder sb = new StringBuilder();
        if(hour==0){
            sb.append("00");
        }else {
            if(hour<10){
                sb.append("0");
             }
            sb.append(String.valueOf(hour));
        }
        sb.append(":");
        if(min==0){
            sb.append("00");
        }else{
            if(min<10){
                sb.append("0");
             }
            sb.append(String.valueOf(min));
        }
        
        return sb.toString();
    }
}
