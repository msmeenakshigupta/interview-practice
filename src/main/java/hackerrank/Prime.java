package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 5/24/19
 */
public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i=0; i<T; i++){
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
             int n = in.nextInt();
            if(n<=1){
                System.out.println("Not prime");
                continue;
            }
            int div=2;
            for( ; div<=Math.sqrt(n); div++){
                if(n%div==0){
                    System.out.println("Not prime");
                    break;
                }
            }
            if(div>Math.sqrt(n))
                System.out.println("Prime");

        }
        in.close();

    }

}
