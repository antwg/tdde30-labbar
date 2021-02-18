package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;

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
	frame.pack();
	frame.setVisible(true);

    }
}

