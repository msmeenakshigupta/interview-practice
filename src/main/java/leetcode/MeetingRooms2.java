class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0)
            return 0;
        
        int len  = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for(int i=0; i<len; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s=0, e=0;
        int rooms =0;
        while(s<len){
            if(start[s]>=end[e]){
                rooms--;
                e++;
            }
            rooms++;
            s++;
        }
            
        return rooms;
       
       
    }
}

