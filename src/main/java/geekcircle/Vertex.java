package com.geekcircle;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int number;
    private int weight;
    private List<Vertex> path;

    public Vertex(int number, int weight) {
        this.number = number;
        this.weight = weight;
        path = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Vertex> getPath() {
        return path;
    }

    public void addAllPath(List<Vertex> vertices) {
        this.path.clear();
        this.path.addAll(vertices);
        this.path.add(this);
    }
}