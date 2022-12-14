package com.delug3.rickandmorty.common.network;

import com.delug3.rickandmorty.episode.repository.EpisodeApiService;

public class EpisodeApiUtils {

    public EpisodeApiUtils() {

    }

    public static EpisodeApiService getEpisodesApiService() {
        return RetrofitClient
                .getClientPublic()
                .create(EpisodeApiService.class);
    }

}
