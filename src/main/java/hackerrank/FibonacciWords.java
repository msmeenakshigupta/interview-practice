package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 4/15/19
 */
public class FibonacciWords {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long A, B;
        int n;
        int[] out = new int[q];
        for(int i=0; i<q; i++){
            A = scanner.nextLong();
            B = scanner.nextLong();
            n = scanner.nextInt();
            out[i] = findPosition(A,B,n);
        }
        for(int i=0; i<q; i++){
            System.out.println(out[i]);
        }
    }

    private static int findPosition(long a, long b, int n) {
        int position =0;
        boolean found = false;

        String str1 =Long.toString(a);
        if(str1.length()>n){
            position = Character.getNumericValue(str1.charAt(n-1));
            return position;
        }
        String str2 = Long.toString(b);
        if(str2.length()>n){
            position = Character.getNumericValue(str2.charAt(n-1));
            return position;
        }

        while(!found){
            String str = str1 + str2;
            if(str.length()>n){
                position = Character.getNumericValue(str.charAt(n-1));
                found = true;
            }else {
                str1 = str2;
                str2 = str;
            }
        }

        return position;
    }
}
