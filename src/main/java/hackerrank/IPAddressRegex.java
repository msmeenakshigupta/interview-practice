package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 11/22/19
 */
public class IPAddressRegex {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex{

    //pattern to validate IP address a.b.c.d
    //0-255

    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    public String pattern = "(" + zeroTo255 + "\\.){3}" + zeroTo255;

}