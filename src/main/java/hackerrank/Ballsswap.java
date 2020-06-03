package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 5/6/19
 */
public class Ballsswap {

    public static int solution(String S) {
        // write your code in Java SE 8
        int swaps = 0;
        int countR = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='R'){
                countR++;
            }

        }
        int x = countR;
        int n = S.length();
        int maxR = Integer.MIN_VALUE;
        int preCompute[] = new int[n];

        for (int i = 1; i < n; i++) {
            if (S.charAt(i) == 'R') {
                preCompute[i] = preCompute[i - 1] + 1;
            } else
                preCompute[i] = preCompute[i - 1];
        }
        for (int i = x - 1; i < n; i++) {
            if (i == (x - 1))
                countR = preCompute[i];
            else
                countR = preCompute[i] - preCompute[i - x];

            if (maxR < countR)
                maxR = countR;
        }

         swaps = x - maxR;
        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String s = scanner.next();
        System.out.println(solution(s));
    }
}
