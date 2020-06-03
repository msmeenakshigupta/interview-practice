package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 4/16/19
 */
public class TableOfN {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        for(int i=1; i<=10; i++){
            System.out.println(n +" x "+ i +" = "+ (n*i));
        }
    }
}
