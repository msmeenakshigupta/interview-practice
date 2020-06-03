package HackerRank;

import java.util.Scanner;
import java.util.Stack;

/**
 * created by megupta on 5/1/19
 * The binary representation of  13 is 1101 , so the maximum number of consecutive 's is 2.
 */
public class DecToBinaryMax1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
        Stack<Integer> bin  = new Stack<>();
        while(n>0){
            bin.push(n%2);
            n=n/2;
        }
        int maxLen =0;
        int consecutiveOnes = 0;
        while(!bin.empty()){
            int check = bin.pop();
            if(check ==1){
                consecutiveOnes++;
            }else{
                if(maxLen<consecutiveOnes)
                    maxLen = consecutiveOnes;
                consecutiveOnes = 0;
            }

        }

        if(consecutiveOnes>maxLen)
            maxLen = consecutiveOnes;
        System.out.println(maxLen);
    }
}
