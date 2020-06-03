import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * created by megupta on 04/05/20
 */
public class Shuffle {

    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        print(obj.shuffle());
        System.out.println("--------------");
        print(obj.reset());
        System.out.println("--------------");
        print(obj.shuffle());
    }

    private static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    static class Solution {
        private int[] array;
        private int[] original;

        private Random rand = new Random();

        private List<Integer> getArrayCopy() {
            List<Integer> asList = new ArrayList<Integer>();
            for (int i = 0; i < array.length; i++) {
                asList.add(array[i]);
            }
            return asList;
        }

        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        public int[] reset() {
            array = original;
            original = original.clone();
            return array;
        }

        public int[] shuffle() {
            List<Integer> aux = getArrayCopy();

            for (int i = 0; i < array.length; i++) {
                int removeIdx = rand.nextInt(aux.size());
                array[i] = aux.get(removeIdx);
                aux.remove(removeIdx);
            }

            return array;
        }

    }

}
