package se.liu.antwe841.tetris;

import java.util.Random;

public enum SquareType
{
    EMPTY, I, O, T, S, Z, J, L;

    public static void main(String[] args) {
	Random rnd = new Random();
	SquareType[] blockArray = SquareType.values();

	for (int i = 0; i < 25; i++) {
	    SquareType currentBlock = blockArray[rnd.nextInt(blockArray.length)];
	    System.out.println(currentBlock);
	}
    }

}

