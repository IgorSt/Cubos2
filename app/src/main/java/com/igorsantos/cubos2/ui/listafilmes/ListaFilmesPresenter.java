package com.igorsantos.cubos2.ui.listafilmes;

import com.igorsantos.cubos2.data.mapper.FilmeMapper;
import com.igorsantos.cubos2.data.model.Filme;
import com.igorsantos.cubos2.data.networking.ApiService;
import com.igorsantos.cubos2.data.networking.response.FilmesResult;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter{

    private ListaFilmesContrato.ListaFilmesView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view){
        this.view = view;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance().obterFilmesPopulares("e563e88d9a10ef303247a9d10500cfbc").enqueue(new Callback<FilmesResult>() {
            @Override
            public void onResponse(retrofit2.Call<FilmesResult> call, Response<FilmesResult> response) {
                if(response.isSuccessful()){
                    final List<Filme> listaFilmes = FilmeMapper.deResponseParaDominio(response.body().getResultadoFilmes());

                    view.mostraFilmes(listaFilmes);
                }else{
                    view.mostraErro();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<FilmesResult> call, Throwable t) {
                view.mostraErro();
            }

        });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
