package com.delug3.rickandmorty.episode;

import com.delug3.rickandmorty.episode.model.Episodes;

import java.util.ArrayList;

public interface Episode {

    interface View {
        void setEpisodesList(ArrayList<Episodes> episodesList);
    }

    interface Presenter {
        void getEpisodes();
    }


    interface Model {

    }

}
