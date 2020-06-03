package HackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * created by megupta on 11/11/19
 */
public class SockMerchant {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int total = findMatchingSocks(n, ar);

        System.out.println(total);
    }

    private static int findMatchingSocks(int n, int[] arr) {
        int matchingPairs =0;
        Set<Integer> colorFound = new HashSet<>();
        for(int i=0; i<n; i++){
            if(colorFound.contains(arr[i])){
                colorFound.remove(arr[i]);
                matchingPairs++;
            }else {
                colorFound.add(arr[i]);
            }

        }
        return matchingPairs;

    }
}
