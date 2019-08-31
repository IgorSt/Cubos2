package com.igorsantos.cubos2.ui.listafilmes.ui.detalhesFilme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.igorsantos.cubos2.R;
import com.igorsantos.cubos2.data.model.Filme;
import com.squareup.picasso.Picasso;

public class DetalhesFilmeActivity extends AppCompatActivity {

    public static final String EXTRA_FILME = "EXTRA_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        TextView textTituloFime = findViewById(R.id.text_titulo_filme);
        TextView textDetalheFilmes = findViewById(R.id.text_detalhe_filme);
        ImageView imageTituloFilme = findViewById(R.id.image_poster_filme);

        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);
        textTituloFime.setText(filme.getTitulo());
        textDetalheFilmes.setText(filme.getDetalhe());
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w342/" + filme.getCaminhoPoster())
                .into(imageTituloFilme);
    }
}
