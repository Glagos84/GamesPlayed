package cl.mind.gamesplayed.data;

import java.util.ArrayList;
import java.util.List;

import cl.mind.gamesplayed.models.Game;

/**
 * Created by Gabriel on 20-08-2017.
 */

public class QueryLastGame {

    public List<Game> lastGame(){

        List<Game> gameLast = new ArrayList<>();
        List<Game> gameLastList = Game.find(Game.class, "done = 1");

        if (gameLastList.size() >0){

            int lastGame = gameLastList.size()-1;

            gameLast.get(lastGame);


        }

            return lastGame();
    }
}
