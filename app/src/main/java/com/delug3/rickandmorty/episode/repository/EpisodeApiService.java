package com.delug3.rickandmorty.episode.repository;

import com.delug3.rickandmorty.episode.model.EpisodesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodeApiService {

    @GET("episode")
    Call<EpisodesResponse> getEpisodes();
}
