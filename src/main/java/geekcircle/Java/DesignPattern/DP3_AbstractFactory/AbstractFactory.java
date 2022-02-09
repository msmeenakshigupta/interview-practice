package com.geekcircle.Java.DesignPattern.DP3_AbstractFactory;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

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
        return "Server{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }

}

interface ComputerAbstractFactory {

    Computer createComputer();

}

class PCFactory implements ComputerAbstractFactory {

    String ram;
    String hdd;
    String cpu;


    public PCFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new PC(ram, hdd, cpu);
    }
}

class ServerFactory implements ComputerAbstractFactory {

    String ram;
    String hdd;
    String cpu;


    public ServerFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram, hdd, cpu);
    }

}

class ComputerFactory {

    static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        Computer computer = ComputerFactory.getComputer(new ServerFactory("2", "3", "4"));
        System.out.println(computer);
    }
}
