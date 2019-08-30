package com.igorsantos.cubos2.data.mapper;

import com.igorsantos.cubos2.data.model.Filme;
import com.igorsantos.cubos2.data.networking.response.FilmesResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmesResponse> listaFilmeResponse){
        List<Filme> listaFilmes = new ArrayList<>();

        for (FilmesResponse filmesResponse : listaFilmeResponse){
            final Filme filme = new Filme(filmesResponse.getTituloOriginal());
            listaFilmes.add(filme);
        }
        return listaFilmes;
    }
}
