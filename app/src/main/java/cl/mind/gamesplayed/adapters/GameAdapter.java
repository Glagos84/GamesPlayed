package cl.mind.gamesplayed.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.mind.gamesplayed.R;
import cl.mind.gamesplayed.data.Query;
import cl.mind.gamesplayed.models.Game;

/**
 * Created by Gabriel on 20-08-2017.
 */

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder>{


    private List<Game> games = new Query().games();
    private GameClick click;

    public GameAdapter(GameClick click) {
        this.click = click;
    }


    /*primer paso para el adapter, es heredar de RecyclerView, luego crear el ViewHolder, e implementar
            los metodos, crear la lista del modelo*/

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // inflar la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_item_list, parent, false);
        return new ViewHolder(view);
    }


     //este metodo me permite, hacer el match de la data en bd vs la lista
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

       final Game game = games.get(position);// saco la position de la lista
        holder.nameGame.setText(game.getNameGame());
        holder.played.setChecked(game.isDone());

        holder.played.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            int auxPosition = holder.getAdapterPosition();
                            Game auxPending = games.get(auxPosition);
                            auxPending.setDone(true);
                            auxPending.save();
                            games.remove(auxPosition);
                            notifyItemRemoved(auxPosition);


                        }
                    },600);

                }
            }
        });

        holder.nameGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Game auxGame = games.get(holder.getAdapterPosition());
                click.clicked(auxGame.getId());

            }
        });

    }


    //al return le debo colocar el largo de la lista, siempre es lo mismo con este metodo
    @Override
    public int getItemCount() {
        return games.size();
    }

    public void update(Game game){

        games.add(game);
        notifyDataSetChanged();

    }


    // segundo crear la clase interna ViewHolder. heredar de RecyclerView.ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder{


        private TextView nameGame;
        private CheckBox played;


        public ViewHolder(View itemView) { // representacion de las filas
            super(itemView);

             /*tercero buscar los id, del list_item.xml y asignarlas a las variables creadas en la
             clase interna*/
            nameGame = itemView.findViewById(R.id.nameGameTv);
            played = itemView.findViewById(R.id.playedCb);

        }
    }



}
