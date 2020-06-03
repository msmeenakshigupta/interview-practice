package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 1/17/20
 */
public class Array1DCanWin {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        boolean canWin = false;
        int i=0 ;
        return isSolvable(leap, game, i);
    }

    private static boolean isSolvable(int m, int[] game, int i) {
        if (i < 0 || game[i] == 1) return false;
        if ((i == game.length - 1) || i + m > game.length - 1) return true;

        game[i] = 1;
        return isSolvable(m, game, i + 1) || isSolvable(m, game, i - 1) || isSolvable(m, game, i + m);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
