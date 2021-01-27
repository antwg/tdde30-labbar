package se.liu.antwe841.tetris;

public class Poly
{
    private SquareType[][] polyArray;
    private int width;
    private int height;
    private SquareType type;

    public Poly(final SquareType[][] polyArray, SquareType type) {
	this.polyArray = polyArray;
	this.width = polyArray[0].length;
	this.height = polyArray.length;
	this.type = type;
    }

    public SquareType[][] getPolyArray() {
        return polyArray;
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
        return height;
    }

    public SquareType getType() {
	return type;
    }
}
