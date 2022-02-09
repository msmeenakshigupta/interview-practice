package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.io.*;

class Company implements Serializable {

    private static final long serialVersionUID = -6849794470754661111L;

    String name;

    Long id;

    private int a;

    //Not consider because its not object level, its class level
    static int c;

    //It will not be consider;
    transient int b;

    public Company(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}

public class SerializationDeserialization {
    public static void main(String[] args) {
        Company c = new Company("Quikr", 1L);
        c.setA(20);
        c.b = 10;
        try {
            //To Write in a File
            OutputStream fos = new FileOutputStream("company.txt");
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(c);
            fos.close();
            ois.close();
        } catch (IOException e){
            System.out.println("Exception while Write");
        }

        try {
            //To Read from File
            InputStream fis = new FileInputStream("company.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Company company = (Company)ois.readObject();
            System.out.println(company);
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Exception while Read");
        }

    }
}
