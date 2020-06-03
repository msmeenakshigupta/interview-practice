package HackerRank;

import java.util.Scanner;



/**
 * created by megupta on 11/22/19
 */
public class LexicographicalSubstring {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        int length =s.length();
        java.util.SortedSet<String> substrings = new java.util.TreeSet();

        for(int i=0; i<=length-k; i++){
            String substr = s.substring(i, i+k);
            substrings.add(substr);
        }

        smallest = substrings.first();
        largest = substrings.last();



        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
