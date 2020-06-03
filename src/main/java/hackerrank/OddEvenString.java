package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 4/22/19
 */
public class OddEvenString {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i=0;i<n; i++){
            String S = scanner.next();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String a="",b="";
            for(int j=0; j<S.length(); j++){
                if(j%2==0)
                    a+=S.charAt(j);
                else
                    b+=S.charAt(j);
            }
            System.out.println(a+ " "+ b);
        }

        scanner.close();


    }
}
