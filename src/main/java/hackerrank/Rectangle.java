package HackerRank;

import java.util.Arrays;

/**
 * created by megupta on 23/04/20
 */
public class Rectangle extends Polygon {

    private double side1, side2;

    public Rectangle(double side1, double side2) {


	    /* Constructor for class Rectangle

	    Implement the logic to initialize the side attribute of this object
	    and the listOfSides attibute inherited from the Parent object.

	    */
        super(Arrays.asList(new Double[] {side1, side2}));
        this.side1 = side1;
        this.side2 = side2;

    }

    public double getArea()
    {
        /* Method which returns the area for this Rectangle object.

		Implement the logic to calculate the area of the object and return it.

		*/
        return side1*side2;

    }
}
