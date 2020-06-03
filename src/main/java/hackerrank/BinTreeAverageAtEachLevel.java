package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by megupta on 25/04/20
 */
public class BinTreeAverageAtEachLevel {

    class Node{
        private int val;
        Node left ;
        Node right ;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public int getVal(){
            return this.val;
        }
    }


    public static void main(String[] args) {

    }


    //by root node
    private int[] averageByDepth(Node node){
        if(node==null){
            return null;
        }else{
            Map<Integer, List<Integer>> numsAtEachLevel = new HashMap<Integer, List<Integer>>();
            numsAtEachLevel = collectVals(node, numsAtEachLevel, 0);
            return arrayOfAverages(numsAtEachLevel);
        }
    }


    private Map<Integer, List<Integer>> collectVals(Node node, Map<Integer, List<Integer>> numsAtEachLevel, int depth){
        if(node!=null) {
            List<Integer> numsAtdepth = new ArrayList<>();
            if(numsAtEachLevel.containsKey(depth)){
                numsAtdepth = numsAtEachLevel.get(depth);
            }
            numsAtdepth.add(node.getVal());
            numsAtEachLevel.put(depth, numsAtdepth);
            collectVals(node.left, numsAtEachLevel, depth+1);
            collectVals(node.right, numsAtEachLevel, depth+1);
        }
        return numsAtEachLevel;

    }

    private int[] arrayOfAverages(Map<Integer, List<Integer>> numsAtEachLevel){
        int[] array = new int[numsAtEachLevel.size()];
        int index =0;
        for(Integer key : numsAtEachLevel.keySet()){
            List<Integer> vals = numsAtEachLevel.get(key);
            int sum =0;
            for(Integer val: vals){
                sum+=val;
            }
            array[index] = sum/vals.size();
            index++;
        }
        return array;
    }
}
