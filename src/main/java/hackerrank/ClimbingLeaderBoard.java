package HackerRank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by megupta on 11/15/19
 */
public class ClimbingLeaderBoard {
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] ranks = new int[alice.length];
        LinkedList<Integer> rankings = new LinkedList<Integer>();
        for(int i=0; i<scores.length; i++){
            if(i==0 || rankings.get(rankings.size()-1)>scores[i])
                 rankings.add(scores[i]);
        }
        int games = alice.length;


        int rank = rankings.size()+1;
        for(int i=0; i<games; i++){
            int aliceScore = alice[i];
            int startIndex = rank-2;
            for(int j=startIndex; j>=0; j--){
                int score = rankings.get(j);
                if(score>aliceScore){
                    break;
                }else if(score<=aliceScore){
                    rank--;
                }
            }
            ranks[i] = rank;


        }

        return ranks;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        Long startTime = new Date().getTime();

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));


        }


        scanner.close();
        Long endTime = new Date().getTime();
        System.out.println("time taken : " +(endTime-startTime));
    }
}
