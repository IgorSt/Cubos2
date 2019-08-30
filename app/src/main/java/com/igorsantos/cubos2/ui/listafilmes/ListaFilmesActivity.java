package com.igorsantos.cubos2.ui.listafilmes;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.igorsantos.cubos2.R;
import com.igorsantos.cubos2.data.mapper.FilmeMapper;
import com.igorsantos.cubos2.data.model.Filme;
import com.igorsantos.cubos2.data.networking.ApiService;
import com.igorsantos.cubos2.data.networking.response.FilmesResult;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {

    RecyclerView recyclerFilmes;

    private ListaFilmesAdapter filmesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configuraToolbar();
        configuraAdapter();
        obtemFilmes();

    }

    private void configuraToolbar(){
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    private void configuraAdapter(){
        recyclerFilmes = findViewById(R.id.recycler_filmes);

        filmesAdapter = new ListaFilmesAdapter();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListaFilmesActivity.this);

        recyclerFilmes.setLayoutManager(linearLayoutManager);
        recyclerFilmes.setAdapter(filmesAdapter);
    }

    private void obtemFilmes(){

        ApiService.getInstance().obterFilmesPopulares("e563e88d9a10ef303247a9d10500cfbc").enqueue(new Callback<FilmesResult>() {
            @Override
            public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                if(response.isSuccessful()){
                    final List<Filme> listaFilmes = FilmeMapper.deResponseParaDominio(response.body().getResultadoFilmes());
                    filmesAdapter.setFilmes(listaFilmes);
                }
            }
            @Override
            public void onFailure(Call<FilmesResult> call, Throwable t) {
            }
        });
    }

    private void mostraErro(){
        Toast.makeText(this, "Erro ao obter lista de filmes", Toast.LENGTH_SHORT).show();
    }
}
