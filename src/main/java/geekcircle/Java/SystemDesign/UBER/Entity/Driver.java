package com.geekcircle.Java.SystemDesign.UBER.Entity;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class Driver {

    private Long id;

    private String name;

    private String mobileNo;

    public Driver(Long id, String name, String mobileNo) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
