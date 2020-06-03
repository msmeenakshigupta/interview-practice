package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 5/13/19
 */

interface AdvancedArithmetic{
    int divisorSum(int n);
}

class ArthCalculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum = n;
        int temp = n;
        while(temp>1){
            temp--;
            if(n%temp == 0)
                sum+=temp;
        }
        return sum;
    }
}
public class ArthCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new ArthCalculator();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}
