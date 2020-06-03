package HackerRank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by megupta on 11/17/19
 */
public class AcmTeamMaxTopics {

    static int[] acmTeam(String[] topic) {
        int[] result = new int[2];

        for(int i=0; i<topic.length; i++){
            String topicsKnownToPersonI = topic[i];
            for(int j=i+1; j<topic.length; j++){
                String topicsKnownToPersonJ = topic[j];
                int topicsKnownToIJ = 0;
                int totalTopics = topicsKnownToPersonI.length();
                for(int k=0; k<totalTopics; k++){
                    if(topicsKnownToPersonI.charAt(k)=='1' || topicsKnownToPersonJ.charAt(k)=='1'){
                        topicsKnownToIJ++;
                    }
                }
                if(result[0]==0 || result[0]<topicsKnownToIJ){
                    result[0] = topicsKnownToIJ;
                    result[1] = 1;
                }else if(result[0]==topicsKnownToIJ){
                        int teams = result[1];
                        result[1] =teams+1;
                    }

            }
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print("\n");
            }
        }

        scanner.close();
    }

}
