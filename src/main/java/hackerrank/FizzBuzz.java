package HackerRank;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created by megupta on 23/04/20
 *
 * program to write number in new line till N. Fizz for multiple of 3, Buzz for multiple of 5, FizzBuzz for both.
 */
public class FizzBuzz {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int noOfTestCases = s.nextInt();
        s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] numbers = new int[noOfTestCases];
        for(int i=0; i<noOfTestCases; i++){
            numbers[i] = s.nextInt();
        }

        List<Integer> ar = new ArrayList<>();
        ar.add(10);
        ar.add(20);
        ar.remove(0);
        s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        //output
        for(int i=0; i<noOfTestCases; i++){
            int maxNumber = numbers[i];
            for(int num=1; num<=maxNumber; num++){
                if(num%3==0 && num%5==0){
                    System.out.println("FizzBuzz");
                }else if(num%3==0){
                    System.out.println("Fizz");
                }else if(num%5==0){
                    System.out.println("Buzz");
                }else{
                    System.out.println(num);
                }
            }
        }
    }
}
