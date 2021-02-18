package se.liu.antwe841.tetris;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTester
{
    public static void main(String[] args) {
	Board testBoard = new Board(10, 20);
	TetrisViewer testViewer = new TetrisViewer(testBoard);
	testBoard.addBoardListener(testViewer.getComp());


	final Action doOneStep = new AbstractAction()
	{
	    @Override public void actionPerformed(final ActionEvent e) {
	        testBoard.replaceWithRandomBoard(testBoard);
	    }
	};

	final Timer clockTimer = new Timer(1000, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
	testViewer.show();

    }
}
