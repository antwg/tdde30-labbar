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
        if (inFalling(falling, x, y)){
            if (squares[y][x] == SquareType.EMPTY){
                return squares[y][x];
	    }
            else {
                return falling.getType();
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

	/*Sets all squares to EMPTY*/

	for (int col = 0; col < width; col++) {
	    for (int row = 0; row < height; row++) {
		squares[row][col] = SquareType.EMPTY;
	    }
	}
    }

    public Board replaceWithRandomBoard(Board board) {
	SquareType[] blockArray = SquareType.values();
	for (int col = 0; col < width; col++) {
	    for (int row = 0; row < height; row++) {
		SquareType currentRNDBlock = blockArray[RND.nextInt(blockArray.length)];
	        squares[row][col] = currentRNDBlock;
	    }
	}
	return board;
    }

    public boolean inFalling(Poly falling, int x, int y){
        List<Integer> xSpan = new ArrayList<>();
	List<Integer> ySpan = new ArrayList<>();
	for (int xCoord = getFallingX(); xCoord < falling.getWidth(); xCoord++) {
	    xSpan.add(xCoord);
	}
	for (int yCoord = getFallingY(); yCoord < falling.getWidth(); yCoord++) {
	    ySpan.add(yCoord);
	}
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
		/*System.out.println(myBoard.getSquareAt(x,y));*/
	    }
	}
	TetrominoMaker maker = new TetrominoMaker();
	Poly falling = maker.getPoly(2);
	/*myBoard.getSquareAt(1,1);*/
    }

}
