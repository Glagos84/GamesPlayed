package cl.mind.gamesplayed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.mind.gamesplayed.adapters.GameAdapter;
import cl.mind.gamesplayed.adapters.GameClick;
import cl.mind.gamesplayed.models.Game;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlayedGameFragment extends Fragment implements GameClick {

    public static final String GAME_ID = "cl.mind.gamesplayed.KEY.PENDING_ID";
    private GameAdapter adapter;

    public PlayedGameFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.playedRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager LayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(LayoutManager);

        adapter = new GameAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void updateList(Game game){

        adapter.update(game);

    }


    @Override
    public void clicked(long id) {

        Intent intent = new Intent(getActivity(), GameDescription.class);
        intent.putExtra(GAME_ID,id);
        startActivity(intent);
    }
}
