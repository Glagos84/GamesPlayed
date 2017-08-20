package cl.mind.gamesplayed;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.mind.gamesplayed.models.Game;

public class MainActivity extends AppCompatActivity {

    private PlayedGameFragment GameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        GameFragment = (PlayedGameFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_create_game);

                ImageButton saveBtn = dialog.findViewById(R.id.saveGameBtn);
                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        EditText userInput = dialog.findViewById(R.id.nameGameEt);
                        String nameGame = userInput.getText().toString();

                        if (nameGame.trim().length() > 0){

                            Game game = new Game();
                            game.setNameGame(nameGame);
                            game.setDone(false);
                            game.save();
                            GameFragment.updateList(game);

                        }

                        dialog.dismiss();

                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT
                        , WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
