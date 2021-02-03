package se.liu.antwe841.tetris;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private final static Random RND = new Random();
    private Poly falling;
    private int fallingX;
    private int fallingY;

    public Poly getFalling() {
	return falling;
    }

    public int getFallingX() {
	return fallingX;
    }

    public int getFallingY() {
	return fallingY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
	return height;
    }

    public SquareType getSquareAt(int x, int y) {
        /*If in falling*/
        if (isInFalling(x, y)){
            if (falling.getPolyArray()[y - getFallingY()][x - getFallingX()] == SquareType.EMPTY){
            	return squares[y][x];
            }
            else {
                return falling.getPolyArray()[y - getFallingY()][x - getFallingX()];
            }
	}
        /*If not in falling*/
        else {
	    return squares[y][x];
	}
    }

    public Board(final int width, final int height) {
	this.squares = new SquareType[height][width];
	this.width = width;
	this.height = height;
	TetrominoMaker maker = new TetrominoMaker();
	this.falling = maker.getPoly(2);  /*temp*/
	this.fallingX = 0;
	this.fallingY = 0;

	/*Sets all squares to EMPTY*/

	for (int col = 0; col < width; col++) {
	    for (int row = 0; row < height; row++) {
		squares[row][col] = SquareType.EMPTY;
	    }
	}
    }

    public Board replaceWithRandomBoard(Board board) { /*inte returna nått*/
	SquareType[] blockArray = SquareType.values();
	for (int col = 0; col < width; col++) {
	    for (int row = 0; row < height; row++) {
		SquareType currentRNDBlock = blockArray[RND.nextInt(blockArray.length)];
	        squares[row][col] = currentRNDBlock;
	    }
	}
	return board;
    }

    public boolean isInFalling(int x, int y){ /*TODO fixa*/
        List<Integer> xSpan = new ArrayList<>();
	List<Integer> ySpan = new ArrayList<>();

	/*Find valid x-coordinates*/
	for (int xCoord = getFallingX(); xCoord < getFallingX() + falling.getWidth(); xCoord++) {
	    xSpan.add(xCoord);
	}

	/*Find valid y-coordinates*/
	for (int yCoord = getFallingY(); yCoord < getFallingY() + falling.getWidth(); yCoord++) {
	    ySpan.add(yCoord);
	}

	/*If both match given x and y values, return true*/
	if (xSpan.contains(x) && ySpan.contains(y)){
	    return true;
	}
	return false;
    }

    /*Test*/
    public static void main(String[] args) {
	Board myBoard = new Board(10, 20);
	for (int y = 0; y < myBoard.getHeight(); y++) {
	    for (int x = 0; x < myBoard.getWidth(); x++) {
		System.out.println(myBoard.getSquareAt(x,y));
	    }
	}
	/*System.out.println(myBoard.inFalling(6,6));
	System.out.println(myBoard.getFallingX());
	System.out.println(myBoard.getFallingY());
	System.out.println(myBoard.getSquareAt(1,1));*/

    }

}
