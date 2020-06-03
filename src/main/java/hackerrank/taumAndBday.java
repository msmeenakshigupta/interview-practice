package HackerRank;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * created by megupta on 11/18/19
 */
public class taumAndBday {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        IntStream.range(0, t).forEach(tItr -> {

            String[] firstMultipleInput = scanner.nextLine().split(" ");

            int b = Integer.parseInt(firstMultipleInput[0]);

            int w = Integer.parseInt(firstMultipleInput[1]);

            String[] secondMultipleInput = scanner.nextLine().split(" ");

            int bc = Integer.parseInt(secondMultipleInput[0]);

            int wc = Integer.parseInt(secondMultipleInput[1]);

            int z = Integer.parseInt(secondMultipleInput[2]);

            long result = taumBday(b, w, bc, wc, z);


            System.out.println(String.valueOf(result));


        });

        scanner.close();
    }


    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        long moneySpent = 0l;

        long bl = b;
        long wl = w;
        long bcl = bc;
        long wcl = wc;
        long zl = z;


        long blacks =     Math.min(bl*bcl, (bl*wcl)+(bl*zl));
        long whites = Math.min(wl*wcl, (wl*bcl)+(wl*zl));

        moneySpent = blacks + whites;



        return moneySpent;
    }

}