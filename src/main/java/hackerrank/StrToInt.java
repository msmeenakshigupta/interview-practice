package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 5/13/19
 */
public class StrToInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try {
            int i = Integer.parseInt(S);
            System.out.println(i);
        }catch (NumberFormatException nfe){
            System.out.println("Bad String");
        }

    }
}
