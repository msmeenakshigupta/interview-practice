package com.geekcircle.Java.DesignPattern.DP2_Factory;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

/*
        I -> Computer
        C -> PC     IMP Computer
        C -> Server IMP Computer
        E -> ComputerType;
        C -> ComputerFactory (With static getComputer)
        Client -> Computer c = new ComputerFactory.getComputer(Type, ....)

 */



interface Computer {

    String getRAM();
    String getHDD();
    String getCPU();

}

class PC implements Computer {

    String ram;
    String hdd;
    String cpu;

    public PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
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
    public String toString() {
        return "PC{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}

class Server implements Computer {

    String ram;
    String hdd;
    String cpu;

    public Server(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return null;
    }

    @Override
    public String getHDD() {
        return null;
    }

    @Override
    public String getCPU() {
        return null;
    }

    @Override
    public String toString() {
        return "Server{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}

enum ComputerType {
    PC, SERVER;
}

class ComputerFactory {

    public static Computer getComputer(ComputerType computerType, String ram, String hdd, String cpu){
        switch (computerType){
            case PC:{
                return new PC(ram, hdd, cpu);
            }
            case SERVER: {
                return new Server(ram, hdd, cpu);
            }
        }
        return null;
    }

}


public class A2_FactoryPattern {

    public static void main(String[] args) {
        Computer computer = ComputerFactory.getComputer(ComputerType.SERVER,"1GB", "256GB", "1.4GHz");
        System.out.println(computer);
    }
}
