package com.geekcircle.ImportantProblems;

public class ExcelNumber {
    public static void main(String[] args) {
        int num = 25;
        System.out.println(getExcelNumber(num));
    }

    private static String getExcelNumber(int num){
        StringBuffer stringBuffer = new StringBuffer();
        while (num > 0){
            double remaining = (double) num % 26;
            num = num/26;
            if(remaining == 0){
                stringBuffer.append('Z');
            } else {
                stringBuffer.insert(0, (char) ((int) 'A'+(remaining-1)));
            }
        }
        return stringBuffer.toString();
    }
}
