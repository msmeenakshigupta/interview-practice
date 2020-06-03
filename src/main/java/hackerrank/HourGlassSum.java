package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * created by megupta on 12/6/19
 */
public class HourGlassSum {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int maxSum = getMaxSumInAllHourGlasses(arr);
        System.out.println(maxSum);

        scanner.close();
    }

    private static int getMaxSumInAllHourGlasses(int[][] arr) {
        int sum=-100;

        int rows = arr.length;
        int cols = arr[0].length;
        for(int i=0; i<=rows-3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                int currentSum = 0;

                int k = j;
                currentSum += arr[i][k] + arr[i][k + 1] + arr[i][k + 2];
                currentSum += arr[i + 1][k + 1];
                currentSum += arr[i + 2][k] + arr[i + 2][k + 1] + arr[i + 2][k + 2];

                if (currentSum > sum)
                    sum = currentSum;
            }

        }
        return sum;
    }
}
