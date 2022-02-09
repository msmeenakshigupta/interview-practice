package com.geekcircle.Java.DesignPattern.DP5_Stratgy;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-14
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

interface Computer {

    String getRAM();

    boolean isSupportSSD();

}

class PC implements Computer {

    String RAM;

    SSD ssd;

    public PC(String RAM) {
        this.RAM = RAM;
        this.ssd = new NotSupportSSD();
    }


    @Override
    public boolean isSupportSSD() {
        return ssd.haveSSD();
    }

    @Override
    public String getRAM() {
        return RAM;
    }

    @Override
    public String toString() {
        return "PC{" +
                "RAM='" + RAM + '\'' +
                ", ssd=" + ssd +
                '}';
    }
}

class Server implements Computer {

    String RAM;

    SSD ssd;

    public Server(String RAM) {
        this.RAM = RAM;
        this.ssd = new SupportSSD();
    }

    @Override
    public String getRAM() {
        return RAM;
    }

    @Override
    public boolean isSupportSSD() {
        return ssd.haveSSD();
    }

    @Override
    public String toString() {
        return "Server{" +
                "RAM='" + RAM + '\'' +
                ", ssd=" + ssd +
                '}';
    }
}

interface SSD {

    boolean haveSSD();

}

class SupportSSD implements SSD{

    @Override
    public boolean haveSSD() {
        return true;
    }
}

class NotSupportSSD implements SSD{

    @Override
    public boolean haveSSD() {
        return false;
    }
}




public class StrategyDesign {
    public static void main(String[] args) {
        Computer c = new Server("100");
        System.out.println(c.isSupportSSD());
        c = new PC("200");
        System.out.println(c.isSupportSSD());
    }
}

