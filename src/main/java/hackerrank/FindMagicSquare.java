package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * created by megupta on 11/13/19
 */
public class FindMagicSquare {
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int cost = 10000;
        final int[][][] possibleSquares = {{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                                            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                                            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                                            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                                            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                                            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                                            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                                            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}};
        for (int i = 0; i < 8; i++) {
            int diff = 0;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    diff += Math.abs(possibleSquares[i][x][y] - s[x][y]);
                }
            }
            if (diff < cost)
                cost = diff;
        }


        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        System.out.println(result);
        scanner.close();
    }
}
