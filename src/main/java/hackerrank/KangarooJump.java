package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 4/23/19
 */
public class KangarooJump {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        String result = "NO";
        boolean canCheck = true;
        //ahead one is already faster
        if((x2>=x1 && v2>v1) || (x1>=x2 && v1>v2) || (x1!=x2 && v1==v2)){
            canCheck = false;
        }

        while (canCheck){
            x1 +=v1;
            x2 +=v2;
            if(x1==x2){
                canCheck = false;
                result = "YES";
            }else if((x2>=x1 && v2>v1) || (x1>=x2 && v1>v2) || (x1!=x2 && v1==v2)){
                canCheck = false;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        scanner.close();
    }

}
