class Solution {
    public String rearrangeString(String s, int k) {
        if(k==0)return s;
        PriorityQueue<Letter> pq = new PriorityQueue<Letter>();
        Letter[] letterMap = new Letter['z'- 'a' + 1];
        char[] strCharArray = s.toCharArray();
        for(char c : strCharArray){
            if(letterMap[c-'a']==null)letterMap[c-'a']= new Letter(c,0);
            letterMap[c-'a'].count++;
        }
        Arrays.stream(letterMap).forEach(a->{
            if(a!=null)pq.add(a);
        });
        Queue<Letter> q = new LinkedList<Letter>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strCharArray.length; i++) {
            if (pq.size() == 0) return "";
            Letter letter = pq.poll();
            sb.append(letter.c);
            letter.count--;
            q.offer(letter);
            if (q.size() == k) {
                Letter poll = q.poll();
                if (poll.count > 0) pq.add(poll);
            }
        }
        return sb.toString();
    }
    
    class Letter implements Comparable<Letter>{
        Character c;
        int count;
        public Letter(Character _c, int _count){
            this.c = _c;
            this.count = _count;
        }
        
        public int compareTo(Letter o){
            if(o.count==this.count){
                return this.c.compareTo(o.c);
            }return o.count - this.count;
        }
    }
}
