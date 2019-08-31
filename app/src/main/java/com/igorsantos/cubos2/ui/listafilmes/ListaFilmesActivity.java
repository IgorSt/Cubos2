package com.igorsantos.cubos2.ui.listafilmes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.igorsantos.cubos2.R;
import com.igorsantos.cubos2.data.model.Filme;
import com.igorsantos.cubos2.ui.listafilmes.ui.detalhesFilme.DetalhesFilmeActivity;

import java.util.List;

public class ListaFilmesActivity extends AppCompatActivity implements ListaFilmesContrato.ListaFilmesView,
        ListaFilmesAdapter.ItemFilmeClickListener {

    private ListaFilmesAdapter filmesAdapter;
    private ListaFilmesContrato.ListaFilmesPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        getSupportActionBar().setElevation(0);

        configuraAdapter();

        presenter = new ListaFilmesPresenter(this);
        presenter.obtemFilmes();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SearchView searchView = new SearchView(this);
        searchView.setOnQueryTextListener(new SearchFiltro());

        MenuItem m1 = menu.add(0, 0, 0, "Item 1");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m1.setActionView(searchView);
        return (true);
    }

    private class SearchFiltro implements SearchView.OnQueryTextListener{

        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            return false;
        }
    }

    private void configuraAdapter(){
        final RecyclerView recyclerFilmes = findViewById(R.id.recycler_filmes);

        filmesAdapter = new ListaFilmesAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerFilmes.setLayoutManager(gridLayoutManager);
        recyclerFilmes.setAdapter(filmesAdapter);
    }

    @Override
    public void mostraFilmes(List<Filme> filmes) {
        filmesAdapter.setFilmes(filmes);
    }

    @Override
    public void mostraErro(){
        Toast.makeText(this, "Erro ao obter lista de filmes", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void onItemFilmeClicado(Filme filme) {
        Intent intent = new Intent(this, DetalhesFilmeActivity.class);
        intent.putExtra(DetalhesFilmeActivity.EXTRA_FILME, filme);
        startActivity(intent);
    }
}
