package se.liu.antwe841.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board {
    private int width, height, fallingX, fallingY, totalScore = 0;
    private boolean gameOver = false;
    private SquareType[][] squares;
    private Poly falling;
    private TetrominoMaker maker;
    private List<BoardListener> boardListeners;

    private final int fallingStartX;
    private final static Random RND = new Random();
    private final static int FALLING_START_Y = 0, MARGIN = 2, DOUBLE_MARGIN = 2 * MARGIN;
    private final static int ONE_ROW = 1, TWO_ROW = 2, THREE_ROW = 3, FOUR_ROW = 4;
    private final static int ONE_ROW_POINTS = 100, TWO_ROW_POINTS = 300, THREE_ROW_POINTS = 500, FOUR_ROW_POINTS = 800;
    private final static Map<Integer, Integer> POINT_MAP = Map.of(ONE_ROW, ONE_ROW_POINTS, TWO_ROW, TWO_ROW_POINTS, THREE_ROW,
								  THREE_ROW_POINTS, FOUR_ROW, FOUR_ROW_POINTS);

    // Constructor
    public Board(final int width, final int height) {
	this.squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
	this.width = width;
	this.height = height;
	this.maker = new TetrominoMaker();
	this.falling = maker.getPoly(RND.nextInt(maker.getNumberOfTypes()));
	this.fallingStartX = (width / 2) - MARGIN;
	this.fallingX = fallingStartX;
	this.fallingY = FALLING_START_Y;
	this.boardListeners = new ArrayList<>();

	//Set correct SquareTypes for empty board

	for (int col = 0; col < width + DOUBLE_MARGIN; col++) {
	    for (int row = 0; row < height + DOUBLE_MARGIN; row++) {
	        if (col >= MARGIN && col < width + MARGIN && row >= MARGIN && row < height + MARGIN) {
		    squares[row][col] = SquareType.EMPTY;
		}
	        else {
		    squares[row][col] = SquareType.OUTSIDE;
		}
	    }
	}
    }


    // ============================================= G/Setters ===============================================================================

    public Poly getFalling() {return falling;}

    public int getFallingX() {return fallingX;}

    public int getFallingY() {return fallingY;}

    public int getWidth() {return width;}

    public int getHeight() {return height;}

    public int getTotalScore() { return totalScore; }

    // ============================================= Public methods ========================================================================


    // 					      --- Falling methods ---

    public void rotate(Direction dir){
	if (falling != null) {
	    Poly copy = falling;

	    if (dir == Direction.RIGHT) {
		copy = falling.rotateRight();
	    } else {
		copy = falling.rotateRight().rotateRight().rotateRight();
	    }
	    if (!hasCollision(copy)) {
		falling = copy;
	    }
	    notifyListeners();
	}
    }

    public void move(Direction direction){
	if (direction == Direction.LEFT){
	    fallingX -= 1;
	}
	else if(direction == Direction.RIGHT){
	    fallingX += 1;
	}
	else if (direction == Direction.DOWN){
	    fallingY += 1;
	}
	else if (direction == Direction.UP){
	    fallingY -= 1;
	}
	if (hasCollision(falling)) {
	    if (direction.equals(Direction.LEFT)) {
		move(Direction.RIGHT);
	    }
	    else if (direction.equals(Direction.RIGHT)){
		move(Direction.LEFT);
	    }
	    else if (direction.equals(Direction.DOWN)){
		move(Direction.UP);
	    }
	}
	notifyListeners();
    }


    // 					      --- Board methods ---

    public void tick(){
	if (!gameOver) {
	    setFalling();
	    moveFalling();
	    fallingHitBottom();
	    removeFull();
	    notifyListeners();
	}
    }

    public SquareType getSquareAt(int x, int y) {
        if (falling != null && isInFalling(x + MARGIN, y + MARGIN)){
	    SquareType fallingSquare = (falling.getSquare(x - getFallingX(),y - getFallingY()));
            //If part of falling is empty
            if (fallingSquare == SquareType.EMPTY){
                //Return from board
            	return squares[y + MARGIN][x + MARGIN]; }
            else {
                //Return from falling
                return fallingSquare; }
        }
        else { return squares[y + MARGIN][x + MARGIN]; }
    }

    public void replaceWithRandomBoard(Board board) {
	SquareType[] blockArray = SquareType.values();
	for (int col = MARGIN; col < width + MARGIN; col++) {
	    for (int row = MARGIN; row < height + MARGIN; row++) {
		SquareType currentRNDBlock = blockArray[RND.nextInt(blockArray.length)];
		squares[row][col] = currentRNDBlock;
	    }
	}
	notifyListeners();
    }

    // 					      --- Others ---


    public void addBoardListener(BoardListener bl){
	boardListeners.add(bl);
    }

    // ============================================= Private methods =======================================================================

    // 					      --- Modify board methods ---

    private void removeFull(){
        int rowsRemoved = 0;
	for (int y = MARGIN; y < height + MARGIN; y++) {
	    if (rowFull(squares[y])){
		moveBoardDown(y);
		rowsRemoved += 1;
	    }
	}
	if (rowsRemoved > 0) {
	    totalScore += POINT_MAP.get(rowsRemoved);
	}
    }

    private void moveBoardDown(int level){
	for (int y = level; y > MARGIN; y--) {
	    for (int x = MARGIN; x < width + MARGIN; x++) {
		squares[y][x] = squares[y - 1][x];
	    }
	}
	for (int x2 = MARGIN; x2 < MARGIN + width; x2++) {
	    squares[MARGIN][x2] = SquareType.EMPTY;
	}
	notifyListeners();
    }

    private void placeFalling(){
	for (int x = 0; x < falling.getWidth(); x++) {
	    for (int y = 0; y < falling.getHeight(); y++) {
		if (falling.getSquare(x, y) != SquareType.EMPTY) {
		    squares[fallingY + y + MARGIN][fallingX + x + MARGIN] = falling.getSquare(x, y); }
	    }
	}
    }

    // 					      --- Falling methods ---

    private void fallingHitBottom(){
	if (hasCollision(falling)){
	    fallingY -= 1;
	    placeFalling();
	    this.falling = null; //Reset falling
	}
    }

    private void setFalling(){
	if (falling == null){
	    falling = maker.getPoly((RND.nextInt(maker.getNumberOfTypes())));
	    fallingX = fallingStartX;
	    fallingY = FALLING_START_Y;
	    //Check Game Over
	    if (hasCollision(falling)){
		gameOver = true;
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

    // 					      --- Others ---

    private boolean rowFull(SquareType[] st){
	for (final SquareType squareType : st) {
	    if (squareType == SquareType.EMPTY) {
		return false;
	    }
	}
	return true;
    }

    private void notifyListeners(){
	for (BoardListener bl: boardListeners) {
		bl.boardChanged(); }
    }

    private boolean hasCollision(Poly pol){
	if (pol != null) {
	    for (int x = 0; x < pol.getWidth(); x++) {
		for (int y = 0; y < pol.getHeight(); y++) {
		    if (pol.getSquare(x, y) != SquareType.EMPTY) {
			if (squares[fallingY + y + MARGIN][fallingX + x + MARGIN] != SquareType.EMPTY) {
			    return true; } } } } }
	return false;
    }
}
