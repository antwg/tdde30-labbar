package se.liu.antwe841.shapes;

import java.awt.*;

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

    @Override public void draw(final Graphics g) {
        /*System.out.println("Ritar: " + this);*/
        int width = radius;
        int height = radius;
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }

    @Override public String toString() {
        return String.format("Circle: Coords: (%d, %d), radius: %d, color: %d, %d, %d",
                             getX(), getY(), radius, color.getRed(), color.getGreen(), color.getBlue());
    }
}
