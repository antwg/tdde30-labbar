package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewer
{
    private JFrame frame;
    private JTextArea textArea;
    private String text;


    public TetrisViewer(Board board) {
	BoardToTextConverter textConverter = new BoardToTextConverter(board);
	this.text = textConverter.convertToText();
	this.frame = new JFrame("Tetris");
	this.textArea = new JTextArea(board.getHeight(), board.getWidth());
    }

    public void show(){
	frame.setLayout(new BorderLayout());
	textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	textArea.setText(text);
	frame.add(textArea, BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);

    }
}
