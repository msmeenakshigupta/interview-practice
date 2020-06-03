package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 11/15/19
 */
public class DivisorDigits {

    static int findDigits(int n) {
        int totaldigits= 0;
        int number = n;
        while(number>0){
            int divisor = number%10;
            if(divisor!=0 && n%divisor==0){
                totaldigits++;
            }
            number=number/10;
        }

        return totaldigits;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            System.out.println(result);
        }



        scanner.close();
    }


}
