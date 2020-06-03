package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 11/20/19
 */
public class BitwiseAndDay29 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            
            findABLessThanK(n,k);
        }

        scanner.close();
    }

    private static void findABLessThanK(int n, int k) {
        int result = 0;
        for(int A=1; A<=n; A++){
            for(int B=A+1; B<=n; B++){
                int temp = A & B ;
                if(temp<k && temp>result)
                    result = temp;
            }
        }
        System.out.println(result);
    }


}
