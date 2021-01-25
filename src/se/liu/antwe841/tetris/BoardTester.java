package se.liu.antwe841.tetris;

public class BoardTester
{
    public static void main(String[] args) {
	Board testBoard = new Board(7, 10);

	for (int i = 0; i < 10; i++) {
	    Board rndBoard = testBoard.replaceWithRandomBoard(testBoard);
	    BoardToTextConverter boardInText = new BoardToTextConverter(rndBoard);
	    System.out.println(boardInText.convertToText());
	}
    }
}
