package com.delug3.rickandmorty.episode.model;

public class Episodes {

    private String episode;
    private String name;
    private Integer id;
    private String air_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirDate() {
        return air_date;
    }

    public void setAirDate(String air_date) {
        this.air_date = air_date;
    }
}
