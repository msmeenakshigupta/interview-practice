package com.geekcircle.Java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Annotation {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date();
        String s = simpleDateFormat.format(date);
        System.out.println(s);
    }
}
