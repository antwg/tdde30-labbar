package se.liu.antwe841.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameManager {
    private HighscoreList highscoreList;
    private Board board;
    private final static int SLEEP_DELAY = 1500;
    private final static int CLOCK_DELAY = 1000;


    // Constructor
    public GameManager(HighscoreList highscoreList) {
        this.highscoreList = highscoreList;
        this.board = new Board(10, 20);
        newGame();
    }

    // ============================================= Getters ===============================================================================


    public HighscoreList getHighscoreList() {
        return highscoreList;
    }

    public Board getBoard() {
        return board;
    }

    // ============================================= Methods ===============================================================================

    public void newGame() {
        // Set up game
        TetrisViewer tetrisViewer = new TetrisViewer(board, highscoreList);
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

        final Action doOneStep = new AbstractAction() {

            @Override public void actionPerformed(final ActionEvent e) {
                board.tick();
            }
        };

        final Timer clockTimer = new Timer(CLOCK_DELAY, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
    }


    public void saveHighscoreList(){
        try {
            highscoreList.saveToJson();
        }
        catch (FileNotFoundException e) {
            if (JOptionPane.showConfirmDialog(null, "Failed to write to highscorelist, try again?", "", JOptionPane.YES_NO_OPTION) ==
                JOptionPane.YES_OPTION) {
                saveHighscoreList();
            } else {
                e.printStackTrace();
            }
        }
    }

    public void readHighscoreList() {
        try {
            highscoreList.readFromJson();
        }
        catch (IOException e) {
            Object[] options = { "Yes", "No, create new" };
            if (JOptionPane.showOptionDialog(null, "Failed to find highscorelist, try again?", "",
                                              JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]) == JOptionPane.YES_OPTION){
                readHighscoreList();
            }
            else {
                highscoreList = new HighscoreList();
                saveHighscoreList();
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HighscoreList highscoreList = new HighscoreList();
        GameManager gameManager = new GameManager(highscoreList);
        gameManager.readHighscoreList();
    }
}
