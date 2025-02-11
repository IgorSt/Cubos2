package com.igorsantos.cubos2.ui.listafilmes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.igorsantos.cubos2.R;
import com.igorsantos.cubos2.data.model.Filme;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<Filme> filmes;
    private static ItemFilmeClickListener itemFilmeClickListener;

    public ListaFilmesAdapter(ItemFilmeClickListener itemFilmeClickListener){
        this.itemFilmeClickListener = itemFilmeClickListener;
        filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bind(filmes.get(position));
    }

    @Override
    public int getItemCount() {
        return (filmes != null && filmes.size() > 0) ? filmes.size() : 0;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder{

        private TextView textTituloFilme;
        private ImageView imagePosterFilme;
        private Filme filme;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);

            textTituloFilme = itemView.findViewById(R.id.text_titulo_filme);
            imagePosterFilme = itemView.findViewById(R.id.image_poster_filme);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemFilmeClickListener != null){
                        itemFilmeClickListener.onItemFilmeClicado(filme);
                    }
                }
            });
        }

        public void bind(Filme filme){
            this.filme = filme;

            textTituloFilme.setText(filme.getTitulo());
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w342/" + filme.getCaminhoPoster())
                    .into(imagePosterFilme);
        }
    }

    public void setFilmes(List<Filme> filmes){
        this.filmes = filmes;
        notifyDataSetChanged();
    }

    public interface ItemFilmeClickListener{

        void onItemFilmeClicado(Filme filme);
    }
}
