package se.liu.antwe841.tetris;

public class Poly
{
    private SquareType[][] polyArray;
    private int width;
    private int height;

    public SquareType[][] getPolyArray() {
	return polyArray;
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public Poly(final SquareType[][] polyArray) {
	this.polyArray = polyArray;
	this.width = polyArray[0].length;
	this.height = polyArray.length;
    }

    public static void main(String[] args) {
	SquareType[][] a =
		{ { SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY }, { SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY } };
	Poly test = new Poly(a);
	System.out.println(test);

	for (int y = 0; y < test.getHeight(); y++) {
	    for (int x = 0; x < test.getWidth(); x++) {
		System.out.println(test.getPolyArray()[y][x]);
	    }
	}
    }
}
