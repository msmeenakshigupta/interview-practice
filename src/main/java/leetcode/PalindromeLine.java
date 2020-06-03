import java.util.Arrays;
import java.util.List;

/**
 * created by megupta on 01/05/20
 */
public class PalindromeLine {

    public static void main(String[] args) {
        String str = ".,";
        System.out.println(isPalindrome(str));



    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        int i=0;
        int j=len-1;
        while(i<j){
            while(!isValidChar(s.charAt(i)) && i<j){
                i++;
            }
            while(!isValidChar(s.charAt(j)) && j>i){
                j--;
            }
            if(s.charAt(i)!=s.charAt(j) && Math.abs(s.charAt(i)-s.charAt(j))!=32)
                return false;
            i++;
            j--;
        }
        return true;

    }
    private static boolean isValidChar(char c){
        if((c>='a' && c<='z') || (c>='A' && c<='Z'))
            return true;
        return false;
    }
}
