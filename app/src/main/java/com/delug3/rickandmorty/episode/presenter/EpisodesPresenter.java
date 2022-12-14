package com.delug3.rickandmorty.episode.presenter;

import android.util.Log;

import com.delug3.rickandmorty.common.network.EpisodeApiUtils;
import com.delug3.rickandmorty.episode.Episode;
import com.delug3.rickandmorty.episode.model.Episodes;
import com.delug3.rickandmorty.episode.model.EpisodesResponse;
import com.delug3.rickandmorty.episode.repository.EpisodeApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class EpisodesPresenter implements Episode.Presenter {

    private final Episode.View episodesView;

    public EpisodesPresenter(Episode.View episodesView) {
        this.episodesView = episodesView;
    }

    public void getEpisodes() {
        EpisodeApiService episodeApiService = EpisodeApiUtils.getEpisodesApiService();
        Call<EpisodesResponse> episodesResponseCall = episodeApiService.getEpisodes();
        episodesResponseCall.enqueue(new Callback<EpisodesResponse>() {
            @Override
            public void onResponse(Call<EpisodesResponse> call, Response<EpisodesResponse> response) {
                if (response.isSuccessful()) {
                    EpisodesResponse episodesResponse = response.body();
                    ArrayList<Episodes> episodesList = episodesResponse.getResults();
                    for (int i = 0; i < episodesList.size(); i++) {
                        Episodes e = episodesList.get(i);
                        Log.e(TAG, "Episodio: " + e.getEpisode());
                        Log.e(TAG, "Titulo: " + e.getName());
                        Log.e(TAG, "Air_Date: " + e.getAirDate());
                    }
                    episodesView.setEpisodesList(episodesList);

                } else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<EpisodesResponse> call, Throwable t) {
                Log.e(TAG, "onFailure" + t.getMessage());
            }
        });
    }
}
