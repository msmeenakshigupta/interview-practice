class Solution {
    public int[][] highFive(int[][] items) {
        
        Map<Integer, List<Integer>> studentMarks = new TreeMap();
        for(int i=0; i<items.length; i++){
            int stu=items[i][0];
            List<Integer> marks = studentMarks.getOrDefault(stu, new ArrayList());
            marks.add(items[i][1]);
            studentMarks.put(stu, marks);
        }
       
        int[][] avg = new int[studentMarks.size()][2];
        int i=0;
        for(Integer stu : studentMarks.keySet()){
            List<Integer> marks = studentMarks.get(stu);
            Collections.sort(marks, Collections.reverseOrder());
           
            int sum=0;
            int limit = marks.size()>5 ? 5 : marks.size();
            for(int j=0; j<limit; j++){
                sum+=marks.get(j);
            }
            int av = (int) sum/limit;
            avg[i++] = new int[]{stu,av};
            
        }
        return avg;
            
    }
}
