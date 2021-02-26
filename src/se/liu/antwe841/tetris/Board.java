package se.liu.antwe841.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private int width;
    private int height;
    private int fallingX;
    private int fallingY;
    private boolean gameOver = false;
    private SquareType[][] squares;
    private Poly falling;
    private TetrominoMaker maker;
    private List<BoardListener> boardListeners;

    private final int fallingStartX;
    private final static int FALLINGSTARTY = 0;
    private static final int MARGIN = 2;
    private static final int DOUBLE_MARGIN = 4;
    private final static Random RND = new Random();

    public Board(final int width, final int height) {
	this.squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
	this.width = width;
	this.height = height;
	this.maker = new TetrominoMaker();
	this.falling = maker.getPoly(RND.nextInt(maker.getNumberOfTypes()));
	this.fallingStartX = (width / 2) - MARGIN;
	this.fallingX = fallingStartX;
	this.fallingY = FALLINGSTARTY;
	this.boardListeners = new ArrayList<>();


	//Set correct SquareTypes for empty board
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

    public Poly getFalling() {return falling;}

    public int getFallingX() {return fallingX;}

    public int getFallingY() {return fallingY;}

    public int getWidth() {return width;}

    public int getHeight() {
	return height;
    }

    // ============================================= Public methods ========================================================================

    public void tick(){
        if (!gameOver) {
	    setFalling();
	    moveFalling();
	    fallingHitBottom();
	    rotate(Direction.RIGHT);
	    notifyListeners();
	}
    }

    public void rotate(Direction dir){
        if (falling != null) {
	    Poly copy = new Poly(new SquareType[height][width]);

	    if (dir == Direction.RIGHT) {
		copy = falling.rotateRight(true);
	    } else {
		copy = falling.rotateRight(true).rotateRight(true).rotateRight(true);
	    }
	    if (!hasCollision(copy)) {
		falling = copy;
	    }
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

    public boolean hasCollision(Poly pol){
        if (pol != null) {
	    for (int x = 0; x < pol.getWidth(); x++) {
		for (int y = 0; y < pol.getHeight(); y++) {
		    if (pol.getSquare(x, y) != SquareType.EMPTY) {
			if (squares[fallingY + y + MARGIN][fallingX + x + MARGIN] != SquareType.EMPTY) {
			    return true; } } } } }
        return false;
    }

    public void addBoardListener(BoardListener bl){ boardListeners.add(bl); }

    public SquareType getSquareAt(int x, int y) {
        if (falling != null && isInFalling(x + MARGIN, y + MARGIN)){
	    //If part of falling is empty
            if (falling.getSquare(x - getFallingX(),y - getFallingY()) == SquareType.EMPTY){
                //Return board
            	return squares[y + MARGIN][x + MARGIN]; }
            else {
                //Return falling
                return falling.getSquare(x - getFallingX(),y - getFallingY()); }
        }
        else { return squares[y + MARGIN][x + MARGIN]; }
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

    private void fallingHitBottom(){
	if (hasCollision(falling)){
	    fallingY -= 1;
	    for (int x = 0; x < falling.getWidth(); x++) {
		for (int y = 0; y < falling.getHeight(); y++) {
		    if (falling.getSquare(x, y) != SquareType.EMPTY) {
			squares[fallingY + y + MARGIN][fallingX + x + MARGIN] = falling.getSquare(x, y); }
		}
	    }
	    //Reset falling
	    fallingX = fallingStartX;
	    fallingY = FALLINGSTARTY;
	    this.falling = null;
	}
    }

    private void setFalling(){
	if (falling == null){
	    falling = maker.getPoly(RND.nextInt(maker.getNumberOfTypes()));
	    //Check Game Over
	    if (hasCollision(falling)){
		gameOver = true;
		System.out.println("Game over");
	    }
	}
    }

    private void moveFalling(){
	if (falling != null){
	    fallingY += 1;
	}
    }

    private boolean isInFalling(int x, int y){
        if (x < getFallingX() + MARGIN || x >= getFallingX() + MARGIN + falling.getWidth() ||
	y < getFallingY() + MARGIN || y >= getFallingY() + MARGIN + falling.getHeight()) {
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
