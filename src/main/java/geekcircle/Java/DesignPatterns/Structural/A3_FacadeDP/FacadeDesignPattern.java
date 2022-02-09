package com.geekcircle.Java.DesignPatterns.Structural.A3_FacadeDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-21
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

interface Shape {
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Facade {
    private Circle circle;
    private Rectangle rectangle;

    public Facade() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
    }

    void drawCircle(){
        circle.draw();
    }

    void drawRectangle(){
        rectangle.draw();
    }
}

public class FacadeDesignPattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.drawCircle();
        facade.drawRectangle();
    }
}
