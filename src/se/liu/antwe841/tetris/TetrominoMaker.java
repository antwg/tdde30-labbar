package se.liu.antwe841.tetris;

public class TetrominoMaker
{
    private int numberOfTypes;

    public TetrominoMaker() {
	this.numberOfTypes = 7;
    }

    public int getNumberOfTypes(){
        return numberOfTypes;
    }

    public Poly getPoly(int n) {
        switch (n) {
	    case 0:
	        return new Poly(getI(), SquareType.I);
	    case 1:
		return new Poly(getO(), SquareType.O);
	    case 2:
		return new Poly(getT(), SquareType.T);
	    case 3:
		return new Poly(getS(), SquareType.S);
	    case 4:
		return new Poly(getZ(), SquareType.Z);
	    case 5:
		return new Poly(getJ(), SquareType.J);
	    case 6:
		return new Poly(getL(), SquareType.L);
	    default:
		throw new IllegalArgumentException("Invalid index: " + n);
	}
    }

    private SquareType[][] getI() {
	SquareType[][] i =
		{ {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
		  {SquareType.I,     SquareType.I,     SquareType.I,     SquareType.I},
		  {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
		  {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY} };
	return i;
    }

    private SquareType[][] getO() {
	SquareType[][] o =
		{ {SquareType.O, SquareType.O},
		  {SquareType.O, SquareType.O} };
	return o;
    }

    private SquareType[][] getT() {
	SquareType[][] t =
		{{SquareType.EMPTY, SquareType.T,     SquareType.EMPTY},
		 {SquareType.T,     SquareType.T,     SquareType.T},
		 {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
	return t;
    }

    private SquareType[][] getS() {
	SquareType[][] s =
		{{SquareType.EMPTY, SquareType.S,     SquareType.S},
		 {SquareType.S,     SquareType.S,     SquareType.EMPTY},
		 {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY} };
	return s;
    }

    private SquareType[][] getZ() {
	SquareType[][] z =
		{{SquareType.Z,     SquareType.Z,     SquareType.EMPTY},
		 {SquareType.EMPTY, SquareType.Z,     SquareType.Z},
		 {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
	return z;
    }

    private SquareType[][] getJ() {
	SquareType[][] j =
		{{SquareType.J,     SquareType.EMPTY, SquareType.EMPTY},
		 {SquareType.J,     SquareType.J,     SquareType.J},
		 {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
	return j;
    }

    private SquareType[][] getL() {
	SquareType[][] l =
		{{SquareType.EMPTY, SquareType.EMPTY, SquareType.J},
		 {SquareType.J,     SquareType.J,     SquareType.J},
		 {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
	return l;
    }
}
