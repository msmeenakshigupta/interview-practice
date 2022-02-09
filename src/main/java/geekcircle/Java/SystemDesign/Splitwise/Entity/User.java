package com.geekcircle.Java.SystemDesign.Splitwise.Entity;

public class User {

    private int id;
    private String name;
    private double get;
    private double give;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public double getGet() {
        return get;
    }

    public void setGet(double get) {
        this.get = get;
    }

    public double getGive() {
        return give;
    }

    public void setGive(double give) {
        this.give = give;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
