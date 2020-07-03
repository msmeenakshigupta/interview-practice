class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b)-> {return a[0]-b[0];});
        Arrays.sort(slots2, (a,b)-> {return a[0]-b[0];});
        int l1=slots1.length;
        int l2=slots2.length;
        int i=0,j=0;
        while(i<l1 && j<l2){
            int start1= slots1[i][0];
            int end1= slots1[i][1];
            int start2=slots2[j][0];
            int end2=slots2[j][1];
            int maxStart = start1<start2 ? start2 : start1;
            int minEnd = end1<end2 ? end1 : end2;
            //found the slot..
            if(maxStart<minEnd){
                int gap = minEnd-maxStart;
                if(gap>=duration){
                    List<Integer> ans = new ArrayList();
                    ans.add(maxStart);
                    ans.add(maxStart+duration);
                    return ans;
                }
            }
            if(end1<end2)
                i++;
            else
                j++;
        }
        return new ArrayList();
    }
}
