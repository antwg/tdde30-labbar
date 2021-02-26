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

    public SquareType getSquare(int x, int y) {
	return polyArray[y][x];
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public Poly rotateRight(boolean right){

	Poly newPoly = new Poly(new SquareType[height][width]);

        for (int r = 0; r < height; r++) {
	    for (int c = 0; c < width; c++){
		newPoly.polyArray[c][width-1-r] = this.polyArray[r][c];
	    }
	}
	return newPoly;
    }

}
