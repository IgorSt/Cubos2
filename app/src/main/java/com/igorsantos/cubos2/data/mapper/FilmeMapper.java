package com.igorsantos.cubos2.data.mapper;

import com.igorsantos.cubos2.data.model.Filme;
import com.igorsantos.cubos2.data.networking.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse){
        List<Filme> listaFilmes = new ArrayList<>();

        for (FilmeResponse filmeResponse : listaFilmeResponse){
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster(),
                    filmeResponse.getDetalheFilme());
            listaFilmes.add(filme);
        }
        return listaFilmes;
    }
}
