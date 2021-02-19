package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener{
    private Board board;

    private final static EnumMap<SquareType, Color> SQUARE_COLORS = createColorMap();

    private final static int SQUARE_SIZE = 30;
    private final static int MARGIN = 5;
    private final static int WINDOW_WIDTH = 350;
    private final static int WINDOW_HEIGHT = 700;

    public TetrisComponent(final Board board) {
	this.board = board;
    }

    @Override public void boardChanged() {
	repaint();
    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	for (int col = 0; col < board.getWidth(); col++) {
	    for (int row = 0; row < board.getHeight(); row++) {
		SquareType squareType = board.getSquareAt(col, row);
		g2d.setColor(SQUARE_COLORS.get(squareType));
		g2d.fillRect(col * (SQUARE_SIZE + MARGIN), row * (SQUARE_SIZE + MARGIN), SQUARE_SIZE, SQUARE_SIZE);
	    }
	}
    }

    public static EnumMap<SquareType, Color> createColorMap(){
	EnumMap<SquareType, Color> map = new EnumMap<>(SquareType.class);

	map.put(SquareType.EMPTY, Color.WHITE);
	map.put(SquareType.I, Color.CYAN);
	map.put(SquareType.O, Color.YELLOW);
	map.put(SquareType.T, Color.MAGENTA);
	map.put(SquareType.S, Color.GREEN);
	map.put(SquareType.Z, Color.RED);
	map.put(SquareType.J, Color.BLUE);
	map.put(SquareType.L, Color.ORANGE);
	map.put(SquareType.OUTSIDE, Color.BLACK);

	return map;
    }

}


