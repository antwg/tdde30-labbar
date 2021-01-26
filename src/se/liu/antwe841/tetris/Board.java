package se.liu.antwe841.tetris;


import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private final static Random RND = new Random();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
	return height;
    }

    public SquareType getSquare(int x, int y) {
	return squares[x][y];
    }

    public Board(final int width, final int height) {
	this.squares = new SquareType[width][height];
	this.width = width;
	this.height = height;

	/*Sets all squares to EMPTY*/

	for (int row = 0; row < height; row++) {
	    for (int col = 0; col < width; col++) {
		squares[col][row] = SquareType.EMPTY;
	    }
	}
    }

    public Board replaceWithRandomBoard(Board board) {
	SquareType[] blockArray = SquareType.values();
	for (int row = 0; row < height; row++) {
	    for (int col = 0; col < width; col++) {
		SquareType currentRNDBlock = blockArray[RND.nextInt(blockArray.length)];
	        squares[col][row] = currentRNDBlock;
	    }
	}
	return board;
    }

    /*Test*/
    public static void main(String[] args) {
	Board myBoard = new Board(3, 5);
	for (int y = 0; y < myBoard.getHeight(); y++) {
	    for (int x = 0; x < myBoard.getWidth(); x++) {
		System.out.println(myBoard.getSquare(x,y));
	    }
	}
    }

}
