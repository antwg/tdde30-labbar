package se.liu.antwe841.tetris;

import java.util.Random;

public class Board {
    private SquareType[][] squares;
    private int width;
    private int height;
    private int fallingX;
    private int fallingY;
    private final static Random RND = new Random();
    private Poly falling;

    public Board(final int width, final int height) {
	this.squares = new SquareType[height][width];
	this.width = width;
	this.height = height;
	TetrominoMaker maker = new TetrominoMaker();
	final int polyNumber = 2;
	this.falling = maker.getPoly(polyNumber);  /*temp*/
	this.fallingX = 0;
	this.fallingY = 0;

	/*Sets all squares to EMPTY*/

	for (int col = 0; col < width; col++) {
	    for (int row = 0; row < height; row++) {
		squares[row][col] = SquareType.EMPTY;
	    }
	}
    }


    public Poly getFalling() {
	return falling;
    }

    public int getFallingX() {return fallingX; }

    public int getFallingY() {
	return fallingY;
    }

    public int getWidth() {return width; }

    public int getHeight() {
	return height;
    }

    public SquareType getSquareAt(int x, int y) {
        if (isInFalling(x, y)){
	    /*If part of falling is empty*/
            if (falling.getSquare(x - getFallingX(),y - getFallingY()) == SquareType.EMPTY){
            	return squares[y][x];
            }
            else {
                return falling.getSquare(x - getFallingX(),y - getFallingY());
            }
	}
        else {
	    return squares[y][x];
	}
    }

    public void replaceWithRandomBoard(Board board) {
	SquareType[] blockArray = SquareType.values();
	for (int col = 0; col < width; col++) {
	    for (int row = 0; row < height; row++) {
		SquareType currentRNDBlock = blockArray[RND.nextInt(blockArray.length)];
	        squares[row][col] = currentRNDBlock;
	    }
	}
    }

    private boolean isInFalling(int x, int y){
        if (x < getFallingX() || x >= getFallingX() + falling.getWidth() ||
	y < getFallingY() || y >= getFallingY() + falling.getHeight()) {
            return false;
        }
	return true;
    }

    /*Test*/
    public static void main(String[] args) {
	Board myBoard = new Board(10, 20);
	/*for (int y = 0; y < myBoard.getHeight(); y++) {
	    for (int x = 0; x < myBoard.getWidth(); x++) {
		System.out.println(myBoard.getSquareAt(x,y));
	    }
	}
	System.out.println(myBoard.isInFalling(0,0));
	System.out.println(myBoard.getFallingX());
	System.out.println(myBoard.getFallingY());
	System.out.println(myBoard.getFallingX() + myBoard.falling.getWidth());
	System.out.println(myBoard.getFallingY() + myBoard.falling.getHeight());
	System.out.println(myBoard.getSquareAt(9,19));*/

    }

}
