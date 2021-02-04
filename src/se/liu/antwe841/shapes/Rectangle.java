package se.liu.antwe841.shapes;

import java.awt.Color;

public class Rectangle extends AbstractShape{
    private int width;
    private int height;

    public Rectangle(final int x, final int y, final int width, final int height, final Color color) {
	super(x, y, color);
	this.width = width;
	this.height = height;
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    @Override public void draw() {
	System.out.println("Ritar: " + this);
    }

    @Override public String toString() {
	return String.format("Rectangle: Coords: (%d, %d), width: %d, height: %d, color: %d, %d, %d",
			     x, y, width, height, color.getRed(), color.getGreen(), color.getBlue());
    }
}
