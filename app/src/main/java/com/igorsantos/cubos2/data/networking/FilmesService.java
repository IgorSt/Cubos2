package com.igorsantos.cubos2.data.networking;

import com.igorsantos.cubos2.data.networking.response.FilmeResponse;
import com.igorsantos.cubos2.data.networking.response.FilmesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

    @GET("movie/popular")
    Call<FilmesResult> obterFilmesPopulares (@Query("api key") String chaveApi, @Query("language") String idioma);
}
