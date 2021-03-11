package se.liu.antwe841.tetris;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HighscoreList {
    private List<Highscore> scores;
    private String fileName = "highScoreList.txt";

    // Constructor
    public HighscoreList() {
	this.scores = new ArrayList<>();
    }

    // ================================================ Getters ============================================================================


    public List<Highscore> getScores() {
        return scores;
    }

    // ================================================  Public Methods ====================================================================

    public void addScore(Highscore highscore) throws FileNotFoundException {
        scores.add(highscore);
        List<Highscore> unsortedScores = this.scores;
        unsortedScores.sort(new ScoreComparator());
        saveToJson();
    }

    public void saveToJson() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String listAsJson = gson.toJson(getScores());

        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            printWriter.write(listAsJson);
        }
    }

    public void readFromJson() throws IOException, FileNotFoundException {
        try (FileReader fileReader = new FileReader(fileName)) {
            Type listType = new TypeToken<ArrayList<Highscore>>() {}.getType();
            List<Highscore> listOfHighscores = new Gson().fromJson(fileReader, listType);

            this.scores = listOfHighscores;
        }
    }

    @Override public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        final int WANTEDNAMES = 10;
        int numberOfWantedScores = Math.min(scores.toArray().length, WANTEDNAMES);

        for (int i = 0; i < numberOfWantedScores; i++) {
            stringBuilder.append(scores.get(i));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
