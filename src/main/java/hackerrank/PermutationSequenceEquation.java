package HackerRank;

import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * created by megupta on 11/14/19
 *
 *

 *
 *
 */
public class PermutationSequenceEquation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        scanner.close();

        int[] result = permutationEquation(n, p);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] permutationEquation(int n, int[] p) {
        int[] resultArr = new int[n];
        List<Integer> pList =Arrays.stream(p)
                .boxed()
                .collect(Collectors.toList());
        for(int x=1; x<=n; x++){
            int a = pList.indexOf(x)+1;
            int y = pList.indexOf(a)+1;
            if(y==0)
                y=1;
            resultArr[x-1]=y;
        }
        return resultArr;
    }
}
