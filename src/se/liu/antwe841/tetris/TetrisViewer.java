package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer {
    private Board board;
    private JFrame frame;
    private TetrisComponent comp;

    public TetrisViewer(Board board) {
	this.board = board;
	this.comp = new TetrisComponent(board);
    }

    public TetrisComponent getComp() {
	return comp;
    }

    public void show(){
	this.frame = new JFrame("Tetris");
	frame.setLayout(new BorderLayout());
	frame.add(comp, BorderLayout.CENTER);
	keyStrokeActions(frame.getRootPane());
	frame.pack();
	frame.setVisible(true);
    }

    private void keyStrokeActions(JComponent pane){
	final InputMap in = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");

	final ActionMap act = pane.getActionMap();
	act.put("moveLeft", new MoveAction(Direction.LEFT));
	act.put("moveRight", new MoveAction(Direction.RIGHT));
    }

    private class MoveAction extends AbstractAction {
	private final Direction moveCommand;


	private MoveAction(final Direction moveCommand){
	    this.moveCommand = moveCommand;
	}

	@Override public void actionPerformed(final ActionEvent e) {
	    board.move(moveCommand);
	}
    }
}


