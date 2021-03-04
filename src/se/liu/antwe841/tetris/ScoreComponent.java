package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;

public class ScoreComponent extends JComponent implements BoardListener {
    private Board board;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final int SIZE = 30;

    public ScoreComponent(final Board board) {
	this.board = board;
    }

    @Override public void boardChanged() {
	repaint();
    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(WIDTH, HEIGHT);
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	g.setColor(Color.BLACK);
	g.setFont(new Font("serif", Font.PLAIN, SIZE));
	g.drawString("Score: " + board.getTotalScore(), 10, 30);

    }
}
