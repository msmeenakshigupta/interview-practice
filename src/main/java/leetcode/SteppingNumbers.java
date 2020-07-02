class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
         Queue<Long> q = new LinkedList();
        List<Integer> l = new ArrayList();
        
        if (low == 0)
            l.add(low++);
        
        Long z = 1L;
        while (z<10)
            q.add(z++);
        
        while (!q.isEmpty()) {
            Long i = q.poll();
            if (i>high) 
                continue;
            Long k = i%10;
            
            if (k>0L) q.add(i*10 + k - 1);
            if (k<9L) q.add(i*10 + k + 1);
            if (i>=low) 
                l.add(i.intValue());
        }
        
        return l;
    }
}
