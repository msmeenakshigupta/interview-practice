class Vector2D {
    Queue<Integer> que = new LinkedList();
    public Vector2D(int[][] v) {
        for(int i=0; i<v.length; i++){
            for(int j=0; j<v[i].length; j++){
                que.add(v[i][j]);
            }
        }
    }
    
    public int next() {
        return que.poll();
    }
    
    public boolean hasNext() {
        if(que.size()>0)
            return true;
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
