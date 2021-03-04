package se.liu.antwe841.tetris;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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

    public void addScore(Highscore highscore){
        scores.add(highscore);
        saveHighScoreList();
    }

    public void saveHighScoreList(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String listAsJson = gson.toJson(getScores());

        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            printWriter.write(listAsJson);
        }
        catch (IOException e) {
            System.out.println("Error " +  " " + e);
        }
    }

    public void readFromJson(){
        try (FileReader fileReader = new FileReader(fileName)) {
            Type listType = new TypeToken<ArrayList<Highscore>>(){}.getType();
            List<Highscore> list = new Gson().fromJson(fileReader, listType);

            this.scores = list;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
