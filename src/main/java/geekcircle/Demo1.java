package com.geekcircle;

class Manager implements Cloneable {
    int id = 10;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Manager m = new Manager();
        System.out.println(m);
        m.id = 10;
        try {
            Manager n = (Manager) m.clone();
            Manager o = m;
            System.out.println(n);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
