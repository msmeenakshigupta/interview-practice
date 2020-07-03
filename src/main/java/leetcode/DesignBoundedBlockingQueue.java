class BoundedBlockingQueue {

    LinkedList<Integer> bbq;
    int cap;
    public BoundedBlockingQueue(int capacity) {
        this.bbq = new LinkedList();
        this.cap=capacity;
    }
    
    public synchronized void enqueue(int element) throws InterruptedException {
        while(bbq.size()==cap)
            wait();
        bbq.addFirst(element);
        notifyAll();
    }
    
    public synchronized int dequeue() throws InterruptedException {
        while(bbq.isEmpty())
            wait();
        
        int ans= bbq.pollLast();
        notifyAll();
        return ans;
    }
    
    public int size() {
        return bbq.size();
    }
}
