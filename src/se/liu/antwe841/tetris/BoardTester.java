package se.liu.antwe841.tetris;

public class BoardTester
{
    public static void main(String[] args) {
	Board testBoard = new Board(10, 20);
	/*testBoard.replaceWithRandomBoard(testBoard);*/
	TetrisViewer testViewer = new TetrisViewer(testBoard);
	testViewer.show();
    }
}
