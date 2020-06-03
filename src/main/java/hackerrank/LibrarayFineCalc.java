package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 5/13/19
 */
public class LibrarayFineCalc {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int actDay = scanner.nextInt();
        int actMonth = scanner.nextInt();
        int actYear = scanner.nextInt();

        int expDay = scanner.nextInt();
        int expMonth = scanner.nextInt();
        int expYear = scanner.nextInt();

        int fine = 0;
        if(expYear >= actYear){
            int diffMonth = (expYear - actYear)*12;
            expMonth += diffMonth;
            if(expMonth >= actMonth){
                int diffDays = (expMonth - actMonth)*31;
                expDay +=diffDays;
                if(actDay > expDay){
                    fine = 15 * (actDay - expDay);
                }
            }else{
                fine = 500 * (actMonth - expMonth);
            }

        }else {
            fine = 10000;
        }
        System.out.println(fine);
    }
}
