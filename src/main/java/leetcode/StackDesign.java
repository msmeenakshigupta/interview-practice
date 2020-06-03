import java.util.LinkedList;
import java.util.List;

/**
 * created by megupta on 04/05/20
 */
public class StackDesign {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(4);
        obj.push(1);
        int res = obj.getMin();
        obj.pop();
        res = obj.top();
        res = obj.getMin();
    }

    static  class MinStack {
        private List<Integer> arr;
        private int size;
        private List<Integer> minList ;

        /** initialize your data structure here. */
        public MinStack() {
            this.arr = new LinkedList<Integer>();
            this.size = 0;
            this.minList = new LinkedList<Integer>();
        }

        public void push(int x) {
            this.arr.add(x);
            this.size++;


            System.out.println(Integer.toString(Integer.parseInt(String.valueOf(x), 10), 2));

            int len = this.minList.size();
                if(len==0){
                    this.minList.add(x);
                }else{
                    int topEle = this.minList.get(len-1);
                    if(topEle < x){
                        this.minList.remove(len-1) ;
                        this.minList.add(x);
                        this.minList.add(topEle);
                    }else{
                        this.minList.add(x);
                    }
                }


        }

        public void pop() {
            size = size-1;
            Integer num = this.arr.remove(size);
            this.minList.remove(num);
        }

        public int top() {
            return this.arr.get(size-1);
        }

        public int getMin() {
            int len = this.minList.size();
            return this.minList.get(len-1);
        }
    }
}
