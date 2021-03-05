package se.liu.antwe841.tetris;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameRunner {
    private HighscoreList highscoreList;

    // Constructor
    public GameRunner() {
        this.highscoreList =  new HighscoreList();
    }

    // ============================================= Getters ===============================================================================


    public HighscoreList getHighscoreList() {
        return highscoreList;
    }

    // ============================================= Methods ===============================================================================


    public void newGame(GameRunner gameRunner){
        BoardTester boardTester = new BoardTester(gameRunner);
        boardTester.runGame(boardTester);
    }

    private void readHighscoreList(GameRunner gameRunner) throws IOException, FileNotFoundException {
        try {
            gameRunner.highscoreList.readFromJson();
        }
        catch (IOException e) {
            Object[] options = { "Yes", "No, create new" };
            if (JOptionPane.showOptionDialog(null, "Failed to find highscorelist, try again?", "",
                                              JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]) == JOptionPane.YES_OPTION){
                readHighscoreList(gameRunner);
            }
            else {
                gameRunner.highscoreList = new HighscoreList();
                highscoreList.saveHighScoreList();
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        GameRunner gameRunner = new GameRunner();
        gameRunner.newGame(gameRunner);
        gameRunner.readHighscoreList(gameRunner);
    }
}
