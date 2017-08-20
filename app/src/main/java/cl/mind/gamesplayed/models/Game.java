package cl.mind.gamesplayed.models;

import com.orm.SugarRecord;

/**
 * Created by Gabriel on 20-08-2017.
 */

public class Game extends SugarRecord {

    private String nameGame, description;
    boolean done;

    public Game() {
    }

    public Game(String nameGame, String description, boolean done) {
        this.nameGame = nameGame;
        this.description = description;
        this.done = done;
    }


    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
