package se.liu.antwe841.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CircleTest {
    public static void main(String[] args) {
	final List<Circle> circles = new ArrayList<>();

	Circle c1 = new Circle(1, 1, 1, Color.BLACK);
	Circle c2 = new Circle(2,2,2, Color.BLACK);
	Circle c3 = new Circle(3, 3, 3, Color.BLACK);

	circles.add(c1);
	circles.add(c2);
	circles.add(c3);

	for (Circle circle : circles) {
	    System.out.println(circle.getX() + "," + circle.getY());
	}
    }
}
