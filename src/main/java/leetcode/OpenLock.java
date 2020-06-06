class Solution {
    public int openLock(String[] deadends, String target) {
       Set<String> ban = new HashSet<>(Arrays.asList(deadends));
        if (ban.contains(target) || ban.contains("0000")) return -1;
        Queue<Candidate> q = new PriorityQueue(1, new Comparator<Candidate>(){
            public int compare(Candidate a, Candidate b) {
                if (a.diff > b.diff) return 1;
                return -1;
            }
        });
        q.offer(new Candidate(target, 0));
        while (q.size() > 0) {
            Candidate c = q.poll();
            if (c.s.equals("0000")) return c.depth;
            
            for (int i = 0; i < 4; i++) {
                StringBuilder sb = new StringBuilder(c.s);
                char left = (char)(sb.charAt(i) - 1);
                if (left < '0') { left = '9';}
                char right = (char)(sb.charAt(i) + 1);
                if (right > '9') {right = '0';}
                
                sb.setCharAt(i, left);
                if (!ban.contains(sb.toString())) {
                    q.offer(new Candidate(sb.toString(), c.depth + 1));
                }
                sb.setCharAt(i, right);
                if (!ban.contains(sb.toString())) {
                    q.offer(new Candidate(sb.toString(), c.depth + 1));
                }
            }
            ban.add(c.s);
        }
        return -1;
    }
    class Candidate {
        String s;
        Integer depth, diff;
        public Candidate(String s, int d) {
            this.s = s;
            this.depth = d;
            this.diff = 0;
            // heuristic explore around target
            for (int i = 0; i < 4; i++) {
                this.diff += Math.min(s.charAt(i) - '0', '9' + 1 - s.charAt(i));
            }
        }
    }
}
