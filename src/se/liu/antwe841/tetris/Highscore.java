package se.liu.antwe841.tetris;

public class Highscore {
    private String name;
    private int score;

    public Highscore(final String name, final int score) {
	this.name = name;
	this.score = score;
    }

    public Highscore(){
    }

    public String getName() {
	return name;
    }

    public int getScore() {
	return score;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public void setScore(final int score) {
	this.score = score;
    }

    @Override public String toString() {
	return name + ": " + score;
    }
}
