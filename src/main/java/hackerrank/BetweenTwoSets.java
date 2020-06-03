package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * created by megupta on 11/7/19
 */
public class BetweenTwoSets {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        List<Integer> arr = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = findNumbersBetweenSets(arr, brr);

        System.out.println(total);
    }

    private static int findNumbersBetweenSets(List<Integer> arr, List<Integer> brr) {
        int numbers = 0;
        int aLen = arr.size();
        int bLen = brr.size();
        if(arr.get(aLen-1)<= brr.get(0) && brr.get(0)%arr.get(aLen-1)==0){
            List<Integer> multiplesOfArr = new ArrayList<>();
            int counter =1;
            for(int i=arr.get(aLen-1); i<=brr.get(0); ){
                int j=0;
                for(; j<aLen; j++){
                    if(i%arr.get(j)!=0)
                        break;
                }
                if(j==aLen)
                    multiplesOfArr.add(i);
                i=arr.get(aLen-1)*(++counter);
            }

            List<Integer> divisorsOfBrr = new ArrayList<>();
            for(int i=0; i<multiplesOfArr.size(); i++){
                int val = multiplesOfArr.get(i);
                int j=0;
                for(; j<bLen; j++){
                    if(brr.get(j)%val!=0)
                        break;
                }
                if(j==bLen)
                    divisorsOfBrr.add(val);
            }

//            System.out.println("Numbers in between: "+divisorsOfBrr);
            numbers = divisorsOfBrr.size();
        }

        return numbers;
    }


}
