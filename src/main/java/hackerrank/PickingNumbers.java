package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * created by megupta on 11/11/19
 */
public class PickingNumbers {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<Integer> arr = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        
        int total = pickingNumbers(arr);

        System.out.println(total);
    }

    private static int pickingNumbers(List<Integer> arr) {
        int largestArrSize =0;

        List<List<Integer>> subArrays = new ArrayList<>();
        Collections.sort(arr);
        int i=0;
        createSubArr(arr, i, subArrays);
        for(int j=0; j<subArrays.size(); j++){
            if(largestArrSize<subArrays.get(j).size())
                largestArrSize = subArrays.get(j).size();
        }

        return largestArrSize;
    }

    private static void createSubArr(List<Integer> arr, int i, List<List<Integer>> subArrays) {
        int size = arr.size();
        List<Integer> subArr = new ArrayList<>();
        subArr.add(arr.get(i));
        i++;
        while(i<size){
            int next = arr.get(i);
            if(next-subArr.get(0)>1){
                subArrays.add(subArr);
                createSubArr(arr, i, subArrays);
                break;
            }else{
                subArr.add(arr.get(i));
                i++;

            }
        }
        if(i==size)
            subArrays.add(subArr);
    }

}
