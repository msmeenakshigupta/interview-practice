package com.geekcircle.Java.DesignPattern.DP4_Builder;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Stack;

interface Computer {

    String getRAM();
    String getHDD();
    String getCPU();
    Boolean isGraphicsCardEnabled();
    Boolean isBluetoothEnabled();

}

class PC implements Computer {

    private String ram;
    private String hdd;
    private String cpu;
    private Boolean graphicsCardEnabled;
    private Boolean bluetoothEnabled;

    public PC(Builder builder) {
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.cpu = builder.cpu;
        this.graphicsCardEnabled = builder.graphicsCardEnabled;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

    @Override
    public Boolean isGraphicsCardEnabled() {
        return this.graphicsCardEnabled;
    }

    @Override
    public Boolean isBluetoothEnabled() {
        return this.bluetoothEnabled;
    }

    private static class Builder {
        String ram;
        String hdd;
        String cpu;
        Boolean graphicsCardEnabled;
        Boolean bluetoothEnabled;

        public Builder(String ram, String hdd, String cpu) {
            this.ram = ram;
            this.hdd = hdd;
            this.cpu = cpu;
        }

        public Builder setGraphicsCardEnabled(Boolean graphicsCardEnabled) {
            this.graphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(Boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build(){
            return new PC(this);
        }
    }
}


public class BuilderPattern  {
    public static void main(String[] args) {

    }
}



