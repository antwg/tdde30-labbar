package se.liu.antwe841.tetris;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTester
{
    public static void main(String[] args) {
	Board board = new Board(10, 20);
	TetrisViewer tetrisViewer = new TetrisViewer(board);
	board.addBoardListener(tetrisViewer.getComp());
	tetrisViewer.show();

	final Action doOneStep = new AbstractAction() {
	    @Override public void actionPerformed(final ActionEvent e) {
	        board.tick();
	    }
	};

	final Timer clockTimer = new Timer(1000, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
    }
}
