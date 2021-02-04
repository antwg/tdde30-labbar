package se.liu.antwe841.shapes;

import java.awt.*;
import java.util.ArrayList;

public class ShapeTest
{
    public static void main(String[] args) {
	final ArrayList<Shape> shapes = new ArrayList<>();

	Circle c1 = new Circle(1, 1, 1, Color.BLACK);
	Circle c2 = new Circle(2,2,2, Color.BLACK);
	Circle c3 = new Circle(3, 3, 3, Color.BLACK);

	Rectangle r1 = new Rectangle(1, 1, 11, 11, Color.BLACK);
	Rectangle r2 = new Rectangle(2, 2, 22, 22, Color.BLACK);
	Rectangle r3 = new Rectangle(3, 3, 33, 33, Color.BLACK);

	Text t1 = new Text(1,1,10,Color.BLUE, "text1");
	Text t2 = new Text(2,2,20,Color.BLUE, "text2");
	Text t3 = new Text(3,3,30,Color.BLUE, "text3");

	shapes.add(c1);
	shapes.add(c2);
	shapes.add(c3);

	shapes.add(r1);
	shapes.add(r2);
	shapes.add(r3);

	shapes.add(t1);
	shapes.add(t2);
	shapes.add(t3);

	for (Shape shape : shapes) {
	    shape.draw();
	}
    }
}
