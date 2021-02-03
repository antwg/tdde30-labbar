package se.liu.antwe841.tetris;

public class BoardTester
{
    public static void main(String[] args) {
	Board testBoard = new Board(10, 20);
	Board rndBoard = testBoard.replaceWithRandomBoard(testBoard);
	TetrisViewer testViewer = new TetrisViewer(testBoard);
	testViewer.show();

	/*
	for (int i = 0; i < 10; i++) {
	    Board rndBoard = testBoard.replaceWithRandomBoard(testBoard);
	    BoardToTextConverter boardInText = new BoardToTextConverter(rndBoard);
	    System.out.println(boardInText.convertToText());*/

	    /*BoardToTextConverter boardInText = new BoardToTextConverter(testBoard);
	    System.out.println(boardInText.convertToText());*/
    }
}
