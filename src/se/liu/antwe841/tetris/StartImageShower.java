package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class StartImageShower extends JComponent{
    final ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/tetris.png"));
    private final static int XCOORD = 10;
    private final static int YCOORD = 0;
    private final static int PREFFERED_WIDTH = 350;
    private final static int PREFFERED_HEIGHT = 700;
    private final static double SCALE = 0.8;


    public void paintComponent(final Graphics g) {
	final Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	final AffineTransform old = g2d.getTransform();
	final AffineTransform at = AffineTransform.getScaleInstance(SCALE, SCALE);
	g2d.transform(at);

	icon.paintIcon(this, g, XCOORD, YCOORD);

	g2d.setTransform(old);
    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(PREFFERED_WIDTH, PREFFERED_HEIGHT);
    }
}

