class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> seen = new HashSet<>();
        int count = 0;
        boolean hasCycle = false;
        for (int i = 0; i < N; i++) {
            int[] next = next(cells);
            String token = tokenize(next);
            if (seen.contains(token)) {
                hasCycle = true;
                break;
            } else {
                seen.add(token);
                count++;
            }
            cells = next;
        }
        
        if (!hasCycle) return cells;
        else {
            
            int times = N % count;
            for (int i = 0; i < times; i++) {
                cells = next(cells);
            }
            return cells; 
        }
    }
    
    private int[] next(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            next[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
        }
        return next;
    }
    
    private String tokenize(int[] cells) {
        return Arrays.toString(cells);
    }
}
