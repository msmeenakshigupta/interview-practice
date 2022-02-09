package com.geekcircle.Java.DesignPatterns.Creational.A2_FactoryDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

interface Computer {

    String getRam();
    String getCpu();

}

class PC implements Computer {

    String ram;

    String cpu;

    public PC(String ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getCpu() {
        return this.cpu;
    }

    @Override
    public String toString() {
        return "PC{" +
                "ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}

class Laptop implements Computer{

    String ram;

    String cpu;

    public Laptop(String ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getCpu() {
        return this.cpu;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}

class ComputerFactory {

    public static Computer getComputer(String computer, String ram, String cpu){

        switch (computer){
            case "PC" : {
                return new PC(ram, cpu);
            }
            case "Laptop" : {
                return new Laptop(ram, cpu);
            }
        }
        return null;
    }

}

//Client Class
public class FactoryDesignPattern {
    public static void main(String[] args) {
        Computer computer = ComputerFactory.getComputer("PC", "4 GB", "2.4GHz");
        System.out.println(computer);
    }
}
