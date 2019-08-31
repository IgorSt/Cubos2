package com.igorsantos.cubos2.data.model;

import java.io.Serializable;

public class Filme implements Serializable {

    private final String titulo;
    private final String caminhoPoster;
    private final String detalhe;

    public Filme(String titulo, String caminhoPoster, String detalhe) {
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;
        this.detalhe = detalhe;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getDetalhe() {
        return detalhe;
    }
}
