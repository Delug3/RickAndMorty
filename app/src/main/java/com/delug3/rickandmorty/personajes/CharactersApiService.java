package com.delug3.rickandmorty.personajes;

import com.delug3.rickandmorty.personajes.model.CharactersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharactersApiService {

    @GET("character")
    Call<CharactersResponse> getCharactersList();
}
