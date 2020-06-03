package HackerRank;

import java.util.*;

/**
 * created by megupta on 11/22/19
 */
public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        scan.close();
        String[] substrings = s.trim().split("[ .,?!'_@]+");
        System.out.println(substrings.length);
        for(int i=0; i<substrings.length; i++){
            System.out.println(substrings[i]);
        }
    }
}
