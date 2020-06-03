package HackerRank;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * created by megupta on 4/23/19
 */
public class RegexChecker {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            //Write your code
           try{
               Pattern.compile(pattern);
               System.out.println("Valid");
           }catch (PatternSyntaxException pse){
               System.out.println("Invalid");
           }
           testCases--;
        }
    }
}
