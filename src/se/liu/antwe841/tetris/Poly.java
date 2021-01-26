package se.liu.antwe841.tetris;

public class Poly
{
    private SquareType[][] polyArray;
    private int width;
    private int height;

    public Poly(final SquareType[][] polyArray) {
	this.polyArray = polyArray;
	this.width = polyArray[0].length;
	this.height = polyArray.length;
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
}
