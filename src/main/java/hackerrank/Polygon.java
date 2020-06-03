package HackerRank;

import java.util.List;

/**
 * created by megupta on 23/04/20
 */
abstract public class Polygon {

    // Sides of the polygon in clockwise direction
    private List<Double> sides;

    public List<Double> getSides() {
        return this.sides;
    }

    public Polygon(List<Double> sides)
    {
        this.sides=sides;
    }

    abstract public double getArea();
}

