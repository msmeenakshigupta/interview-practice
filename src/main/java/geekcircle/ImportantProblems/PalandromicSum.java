package com.geekcircle.ImportantProblems;

public class PalandromicSum {
    public static void main(String[] args) {
        int[] arr = {0};

        int len = arr.length;
        int result = 0;

        for (int i = 0; i < len; ++i)
        {
            if (IsNumberSpecial(arr[i]))
                ++result;
        }

        System.out.println(result);
    }

    private static boolean IsNumberSpecial(int input) {
        for (int nb1 = 0; nb1 <= (input / 2); ++nb1) {
            int nb2 = Integer.parseInt(reverseStr(nb1+""));
            if (nb2 + nb1 == input) {
                return (true);
            }
        }
        return (false);
    }


    private static boolean isSpecial(int n) {
        for (int i = (int)Math.floor(n / 2), j = (int)Math.ceil(n / 2); i > 0; i--, j++) {
            if (Integer.parseInt(reverseStr(i+"")) == (Integer.parseInt(j+"")))
                return true;
        }

        return false;
    }

    private static String reverseStr(String string){
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
}
