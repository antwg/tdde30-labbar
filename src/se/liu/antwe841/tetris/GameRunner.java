package se.liu.antwe841.tetris;

public class GameRunner {
    private HighscoreList highscoreList;

    public GameRunner() {
        this.highscoreList =  new HighscoreList();
    }

    public HighscoreList getHighscoreList() {
        return highscoreList;
    }

    public void newGame(GameRunner gameRunner){
        BoardTester boardTester = new BoardTester(gameRunner);
        boardTester.runGame(boardTester);

    }

    public static void main(String[] args) throws InterruptedException {
        GameRunner gameRunner = new GameRunner();
        gameRunner.newGame(gameRunner);
        //gameRunner.highscoreList.addScore(new Highscore("anton", 100));
        //System.out.println(gameRunner.highscoreList.getHighScoreList());
    }


}
