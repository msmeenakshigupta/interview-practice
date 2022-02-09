package com.geekcircle;

import java.util.Objects;

public class GraphVertex <T> {

    private T number;
    private int weight;

    public GraphVertex(T number){
        this(number, 0);
    }

    public GraphVertex(T number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public GraphVertex<T> setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphVertex<?> vertex = (GraphVertex<?>) o;
        return weight == vertex.weight &&
                Objects.equals(number, vertex.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, weight);
    }
}
