package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTester {
    private final static int SLEEP_DELAY = 1500;
    private final static int CLOCK_DELAY = 1000;

    public static void main(String[] args) {
	Board board = new Board(10, 20);
	TetrisViewer tetrisViewer = new TetrisViewer(board);
	board.addBoardListener(tetrisViewer.getComp());

	tetrisViewer.setStartIMG();
	tetrisViewer.show();
	try {
	    Thread.sleep(SLEEP_DELAY);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	tetrisViewer.setBoard();


	final Action doOneStep = new AbstractAction()
	{
	    @Override public void actionPerformed(final ActionEvent e) {
		board.tick();
	    }
	};


	final Timer clockTimer = new Timer(CLOCK_DELAY, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
    }
}
