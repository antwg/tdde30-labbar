package se.liu.antwe841.shapes;

import java.awt.Color;

public class Circle extends AbstractShape{
    private int radius;

    public Circle(final int x, final int y, final int radius, final Color color) {
        super(x, y, color);
        if (radius < 0) {
            throw new IllegalArgumentException("Negativ radie!");
        }
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override public void draw() {
        System.out.println("Ritar: " + this);
    }

    @Override public String toString() {
        return String.format("Circle: Coords: (%d, %d), radius: %d, color: %d, %d, %d",
                             getX(), getY(), radius, color.getRed(), color.getGreen(), color.getBlue());
    }
}
