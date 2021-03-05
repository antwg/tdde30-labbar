package se.liu.antwe841.tetris;

public class Highscore {
    private String name;
    private int score;


    // Constructor
    public Highscore(final String name, final int score) {
	this.name = name;
	this.score = score;
    }

    // ============================================= Getters ===============================================================================

    public String getName() {
	return name;
    }

    public int getScore() {
	return score;
    }

    // ============================================= Methods ===============================================================================

    @Override public String toString() {
	return name + ": " + score;
    }
}
