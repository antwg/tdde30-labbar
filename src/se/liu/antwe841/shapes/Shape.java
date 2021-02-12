package se.liu.antwe841.shapes;

import java.awt.*;

public interface Shape
{
    int getX();

    int getY();

    Color getColor();

    public void draw(final Graphics g);
}
