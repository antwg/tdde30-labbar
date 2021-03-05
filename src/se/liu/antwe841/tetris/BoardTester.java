package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTester {
    public Board board;
    private GameRunner gameRunner;
    private final static int SLEEP_DELAY = 1500;
    private final static int CLOCK_DELAY = 1000;

    // Constructor
    public BoardTester(GameRunner gameRunner) {
	this.board = new Board(10, 20);
	this.gameRunner = gameRunner;
    }

    // ================================================ Getters ============================================================================


    public Board getBoard() {
	return board;
    }

    public GameRunner getGameRunner() {
	return gameRunner;
    }

    // ================================================ Public Methods =====================================================================


    public void runGame(BoardTester boardTester) {
        // Set up game
	TetrisViewer tetrisViewer = new TetrisViewer(boardTester);
	board.addBoardListener(tetrisViewer.getTetrisComponent());
	board.addBoardListener(tetrisViewer.getScoreComponent());

	//Show start image
	tetrisViewer.setStartIMG();
	tetrisViewer.show();
	try {
	    Thread.sleep(SLEEP_DELAY);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	// Run game
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
