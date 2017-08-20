package cl.mind.gamesplayed.data;

import java.util.ArrayList;
import java.util.List;

import cl.mind.gamesplayed.models.Game;

/**
 * Created by Gabriel on 20-08-2017.
 */

public class Query  {

    public List<Game> games(){


       List<Game> games = new ArrayList<>();
        List<Game> gamesList = Game.find(Game.class, "done = 0");

        if (gamesList != null && gamesList.size() > 0){

            games.addAll(gamesList);



        }

        return games;

    }
}
