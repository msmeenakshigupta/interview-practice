package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 5/6/19
 */
public class IdenticalPairs {
    public static int solution(int[] A) {
        // write your code in Java SE 8

        int count = 0;
        int len = A.length;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(A[i]==A[j])
                    count++;

                if(count==1000000000)
                    break;
            }
        }

        return count;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int N = scanner.nextInt();
        if(N<0 || N>100000){
            System.exit(0);
        }
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr));
    }
}
