package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;

public class OldTetrisViewer
{
    private Board board;

    public OldTetrisViewer(Board board) {
	this.board = board;
    }

    public void show(){
	JFrame frame = new JFrame("Tetris");
	BoardToTextConverter textConverter = new BoardToTextConverter(board);
	String text = textConverter.convertToText();
	JTextArea textArea = new JTextArea(board.getHeight(), board.getWidth());
	frame.setLayout(new BorderLayout());
	textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	textArea.setText(text);
	frame.add(textArea, BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);

    }
}

