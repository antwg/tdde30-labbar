package se.liu.antwe841.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DiagramComponent extends JComponent
{
    private List<Shape> shapes;

    public DiagramComponent() {
	this.shapes = new ArrayList<>();
    }

    public void addShape(Shape s){
        shapes.add(s);
    }

    @Override protected void paintComponent(final Graphics g) {
	/*super.paintComponent(g);*/
	for (Shape shape:shapes) {
	    shape.draw(g);
	}
    }

    public static void main(String[] args) {
	DiagramComponent com = new DiagramComponent();
	System.out.println(com);
	Circle c1 = new Circle(1, 1, 1, Color.BLACK);
	com.addShape(c1);
	System.out.println(com);
    }
}
