package com.igorsantos.cubos2.ui.listafilmes;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.igorsantos.cubos2.R;
import com.igorsantos.cubos2.data.model.Filme;

import java.lang.reflect.Array;
import java.util.List;

public class ListaFilmesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerFilmes = findViewById(R.id.recycler_filmes);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerFilmes.setLayoutManager(linearLayoutManager);
        recyclerFilmes.setAdapter(new ListaFilmesAdapter());
    } 
}
