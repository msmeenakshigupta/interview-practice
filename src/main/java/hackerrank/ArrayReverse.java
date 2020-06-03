package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 4/22/19
 */
public class ArrayReverse {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] A = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            A[i] = arrItem;
        }
        scanner.close();
        for(int i=n-1; i>=0; i--){
            System.out.print(A[i]+" ");
        }

    }
}
