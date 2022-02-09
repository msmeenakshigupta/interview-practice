package com.geekcircle.Java.DesignPatterns.Creational.A3_AbstractFactory;

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

    private String ram;

    private String cpu;

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

class Laptop implements Computer {

    private String ram;

    private String cpu;

    public Laptop(String ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    public String getRam() {
        return this.ram;
    }

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

interface ComputerFactory {

    Computer getComputer();

}

class PCFactory implements ComputerFactory{

    private String ram;

    private String cpu;

    public PCFactory(String ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public Computer getComputer() {
        return new PC(ram, cpu);
    }

}

class LaptopFactory implements ComputerFactory{

    private String ram;

    private String cpu;

    public LaptopFactory(String ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public Computer getComputer() {
        return new Laptop(ram, cpu);
    }

}

class AbstractComputerFactory {

    static Computer getComputer(ComputerFactory computerFactory){
        return computerFactory.getComputer();
    }


}

public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        Computer computer = AbstractComputerFactory.getComputer(new PCFactory("2 GB", "2.4GHz"));
        System.out.println(computer);
    }
}
