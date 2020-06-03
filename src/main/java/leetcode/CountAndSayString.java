import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by megupta on 02/05/20
 */
public class CountAndSayString {
    public static void main(String[] args) {
        int n =4;
        System.out.println(countAndSay(n));
        int[] arr = {1,2,3,4,5,6,7};
        int[] aa = new int[3];
        aa = Arrays.copyOfRange(arr, 0, 3);
        BigInteger a = BigInteger.valueOf(1*1);

    }

    public static String countAndSay(int n) {
        String ans = null;
        if (n == 1) {
            ans = "1";
        } else if (n > 1) {


            String val = countAndSay(n-1);
            int num = Integer.valueOf(val.charAt(0)-48);
            System.out.println(num);
            int count =1;
            StringBuilder sb = new StringBuilder();
            if(val.length()>=1){
                {

                    for(int i=1; i<val.length(); i++){
                        int numAt  = Integer.valueOf(val.charAt(i)-48);
                        if(num==numAt){
                            count++;
                        }
                        else{
                            sb.append(count).append(num);
                            count =1;
                            num = numAt;
                        }
                    }

                }
                sb.append(count).append(num);
                ans= sb.toString();

            }
            return ans;

        }
        return ans;
    }
}
