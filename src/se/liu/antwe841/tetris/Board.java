package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private SquareType[][] squares;
    private int width;
    private int height;
    private int fallingX;
    private int fallingY;
    private static final int MARGIN = 2;
    private static final int DOUBLE_MARGIN = 4;
    private final static Random RND = new Random();
    private Poly falling;
    private TetrominoMaker maker;
    private List<BoardListener> boardListeners;


    public Board(final int width, final int height) {
	this.squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
	this.width = width;
	this.height = height;
	this.maker = new TetrominoMaker();
	this.falling = maker.getPoly(RND.nextInt(maker.getNumberOfTypes()));
	this.fallingX = (width + MARGIN)/ 2;
	this.fallingY = MARGIN;
	this.boardListeners = new ArrayList<>();

	for (int col = 0; col < width + DOUBLE_MARGIN; col++) {
	    for (int row = 0; row < height + DOUBLE_MARGIN; row++) {
		squares[row][col] = SquareType.OUTSIDE;
	    }
	}
	for (int col = MARGIN; col < width + MARGIN; col++) {
	    for (int row = MARGIN; row < height + MARGIN; row++) {
		squares[row][col] = SquareType.EMPTY;
	    }
	}
    }

    // ============================================= Getters ===============================================================================

    public Poly getFalling() { return falling; }

    public int getFallingX() {return fallingX; }

    public int getFallingY() { return fallingY; }

    public int getWidth() {return width; }

    public int getHeight() {
	return height;
    }

    // ============================================= Public methods ========================================================================

    public void tick(){
	setFalling();
	moveFalling();
	//hasCollision();
	notifyListeners();
    }

    public void setFalling(){
	if (falling == null){
	    falling = maker.getPoly(RND.nextInt(maker.getNumberOfTypes()));
	}
    }

    public void moveFalling(){
        if (falling != null){
	    fallingY += 1;
	}
    }

    public void move(Direction direction){
        if (direction == Direction.LEFT){
            fallingX -= 1;
	}
        else if(direction == Direction.RIGHT){
            fallingX += 1;
	}
        notifyListeners();
    }
/*
    private boolean hasCollision(){
	//if (getSquareAt(fallingX - MARGIN, fallingY - MARGIN) != SquareType.EMPTY){
	  //  System.out.println("not empty");
	//}
	//if (getSquareAt(fallingX - MARGIN, fallingY - MARGIN) == ){
	  //  System.out.println("falltype");
	//}
	//for (int x = 0; x < falling.getWidth(); x++) {

	//}
	return true;
    }
*/
    public void addBoardListener(BoardListener bl){ boardListeners.add(bl); }

    public SquareType getSquareAt(int x, int y) {
        x += MARGIN;
        y += MARGIN;
        if (isInFalling(x, y)){
	    /*If part of falling is empty*/
            if (falling.getSquare(x - getFallingX(),y - getFallingY()) == SquareType.EMPTY){
            	return squares[y][x]; }
            else {
                return falling.getSquare(x - getFallingX(),y - getFallingY()); }
        }
        else { return squares[y][x]; }
    }

    public void replaceWithRandomBoard(Board board) {
	SquareType[] blockArray = SquareType.values();
	for (int col = 0; col < width; col++) {
	    for (int row = 0; row < height; row++) {
		SquareType currentRNDBlock = blockArray[RND.nextInt(blockArray.length)];
	        squares[row][col] = currentRNDBlock;
	    }
	}
	notifyListeners();
    }

    // ============================================= Private methods =======================================================================

    private void notifyListeners(){
	for (BoardListener bl: boardListeners) {
		bl.boardChanged(); }
    }

    private boolean isInFalling(int x, int y){
        if (x < getFallingX() || x >= getFallingX() + falling.getWidth() ||
	y < getFallingY() || y >= getFallingY() + falling.getHeight()) {
            return false; }
	return true;
    }

    public static void main(String[] args) {
	Board board = new Board(10,20);
	OldTetrisViewer test = new OldTetrisViewer(board);
	BoardToTextConverter text = new BoardToTextConverter(board);
	System.out.println(text.convertToText());
	test.show();
    }
}
