import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * created by megupta on 01/05/20
 */
public class PowerOfThree {

    public static void main(String[] args) {
        int num  = 19684;
//        System.out.println(isPowerOfThree(num));
//        String str = "ssdsd";
//        char[] arr = str.toCharArray();

        int[][] pairs = {{1,2}, {3,4}, {2,3}};
        Arrays.sort(pairs, Collections.reverseOrder());

    }

    public static boolean isPowerOfThree(int n) {
        if(n==1 || n==3)
            return true;
        if(n<3)
            return false;
        while(n>3){
            if(n%3!=0)
                return false;
            n=n/3;
            if(n==3)
                return true;

        }
        return true;
    }
}
