package cl.mind.gamesplayed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import cl.mind.gamesplayed.models.Game;

public class GameDescription extends AppCompatActivity {

    private Game game;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_description);


        long gameId = getIntent().getLongExtra(PlayedGameFragment.GAME_ID,0);
        game = Game.findById(Game.class, gameId);
        getSupportActionBar().setTitle(game.getNameGame());

        editText = (EditText) findViewById(R.id.desGameEt);
        String description = game.getDescription();

        if (description != null){

            editText.setText(description);

        }



    }

    @Override
    protected void onResume() {
        super.onResume();

        game.setDescription(editText.getText().toString());
    }

    @Override
    protected void onPause() {
        super.onPause();

        String description = editText.getText().toString();
        game.setDescription(description);
        game.save();
    }
}
