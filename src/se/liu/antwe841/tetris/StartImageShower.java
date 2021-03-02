package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class StartImageShower extends JComponent{
    private final ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/tetris.png"));
    private final static int X_COORDINATE = 10;
    private final static int Y_COORDINATE = 0;
    private final static int PREFERED_WIDTH = 350;
    private final static int PREFERED_HEIGHT = 700;
    private final static double SCALE = 0.8;


    public void paintComponent(final Graphics g) {
	final Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	final AffineTransform old = g2d.getTransform();
	final AffineTransform at = AffineTransform.getScaleInstance(SCALE, SCALE);
	g2d.transform(at);

	icon.paintIcon(this, g, X_COORDINATE, Y_COORDINATE);

	g2d.setTransform(old);
    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(PREFERED_WIDTH, PREFERED_HEIGHT);
    }
}

