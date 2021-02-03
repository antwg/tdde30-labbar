package se.liu.antwe841.tetris;

public class Poly {
    private SquareType[][] polyArray;
    private SquareType type;
    private int width;
    private int height;

    public SquareType getSquare(int x, int y) {return polyArray[y][x]; }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public SquareType getType() {
	return type;
    }

    public Poly(final SquareType[][] polyArray, SquareType type) {
	this.polyArray = polyArray;
	this.width = polyArray[0].length;
	this.height = polyArray.length;
	this.type = type;
    }
}
