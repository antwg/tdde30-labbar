package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener{
    private Board board;
    private EnumMap<SquareType, Color> squareColors;
    private final static int SQUARE_SIZE = 30;
    private final static int SPACE = 5;
    private final  int componentWidth;
    private final  int componentHeight;

    public TetrisComponent(final Board board) {
	this.board = board;
	this.componentWidth = board.getWidth() * (SQUARE_SIZE + SPACE);
	this.componentHeight = board.getHeight() * (SQUARE_SIZE + SPACE);
	this.squareColors = createColorMap();
    }


    // ============================== Methods ==============================================================================================


    @Override public void boardChanged() {
	repaint();
    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(componentWidth, componentHeight);
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	for (int col = 0; col < board.getWidth(); col++) {
	    for (int row = 0; row < board.getHeight(); row++) {
		SquareType squareType = board.getSquareAt(col, row);
		g2d.setColor(squareColors.get(squareType));
		g2d.fillRect(col * (SQUARE_SIZE + SPACE), row * (SQUARE_SIZE + SPACE), SQUARE_SIZE, SQUARE_SIZE);
	    }
	}
    }

    public final EnumMap<SquareType, Color> createColorMap(){
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


