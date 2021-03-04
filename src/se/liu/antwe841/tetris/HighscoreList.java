package se.liu.antwe841.tetris;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList {
    private List<Highscore> highScoreList;

    public HighscoreList() {
	this.highScoreList = new ArrayList<>();
    }

    public List<Highscore> getHighScoreList() {
	return highScoreList;
    }

    public void addScore(Highscore highscore){
        highScoreList.add(highscore);
    }

}
