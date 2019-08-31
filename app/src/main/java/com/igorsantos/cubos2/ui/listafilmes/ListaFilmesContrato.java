package com.igorsantos.cubos2.ui.listafilmes;

import com.igorsantos.cubos2.data.model.Filme;

import java.util.List;

public interface ListaFilmesContrato {

    interface ListaFilmesView{

        void mostraFilmes(List<Filme> filmes);

        void mostraErro();
    }

    interface ListaFilmesPresenter{

        void obtemFilmes();

        void destruirView();
    }
}
