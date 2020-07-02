class MovingAverage {

    int[] q;
    int size, windowSum=0, count=0, head=0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new int[size];
        this.size = size;
    }
    
    public double next(int val) {
        count++;
        int tail = (head+1)%size;
        windowSum = windowSum - q[tail] +val;
        head  = (head+1)%size;
        q[head] = val;
        return (windowSum*1.0)/Math.min(size, count);
    }
    
   
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
