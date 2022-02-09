package com.geekcircle;

public class GraphEdge <T> {
    private GraphVertex<T> src;
    private GraphVertex<T> dst;
    private int weight;
    private boolean directed;

    public GraphEdge(GraphVertex<T> src, GraphVertex<T> dst) {
        this(src,dst,0);
    }

    public GraphEdge(GraphVertex<T> src, GraphVertex<T> dst, int weight) {
        this(src,dst,weight,false);
    }

    public GraphEdge(GraphVertex<T> src, GraphVertex<T> dst, int weight, boolean directed) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
        this.directed = directed;
    }

    public GraphVertex<T> getSrc() {
        return src;
    }

    public void setSrc(GraphVertex<T> src) {
        this.src = src;
    }

    public GraphVertex<T> getDst() {
        return dst;
    }

    public void setDst(GraphVertex<T> dst) {
        this.dst = dst;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}
