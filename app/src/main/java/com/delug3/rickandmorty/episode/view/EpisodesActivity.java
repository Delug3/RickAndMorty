package com.delug3.rickandmorty.episode.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.delug3.rickandmorty.R;
import com.delug3.rickandmorty.episode.Episode;
import com.delug3.rickandmorty.episode.adapter.EpisodesListAdapter;
import com.delug3.rickandmorty.episode.handler.RecyclerTouchListener;
import com.delug3.rickandmorty.episode.model.Episodes;
import com.delug3.rickandmorty.episode.presenter.EpisodesPresenter;
import com.delug3.rickandmorty.personajes.view.CharactersDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class EpisodesActivity extends AppCompatActivity implements Episode.View {

    private EpisodesPresenter episodesPresenter;
    private RecyclerView recyclerViewEpisodes;
    private EpisodesListAdapter episodesListAdapter;

    List<Episodes> episodesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episodes_main_activity);

        episodesPresenter = new EpisodesPresenter(this);
        recyclerViewEpisodes = findViewById(R.id.recyclerViewEpisodios);
        episodesListAdapter = new EpisodesListAdapter(episodesList);
        recyclerViewEpisodes.setAdapter(episodesListAdapter);
        recyclerViewEpisodes.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerViewEpisodes.setLayoutManager(layoutManager);

        recyclerViewEpisodes.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerViewEpisodes, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Episodio mas info de los caracteres
                Intent i = new Intent(EpisodesActivity.this, CharactersDetailActivity.class);
                i.putExtra("EPISODIO_ID", episodesList.get(position).getId());
                i.putExtra("EPISODIO_CODIGO", episodesList.get(position).getEpisode());
                i.putExtra("EPISODIO_NOMBRE", episodesList.get(position).getName());
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        getEpisodes();
    }

    public void getEpisodes() {
        episodesPresenter.getEpisodes();
    }

    public void setEpisodesList(ArrayList<Episodes> episodesList) {
        episodesListAdapter.addEpisodesList(episodesList);
    }

}
