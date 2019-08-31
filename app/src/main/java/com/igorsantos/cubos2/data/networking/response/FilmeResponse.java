package com.igorsantos.cubos2.data.networking.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;
    @Json(name = "original_title")
    private final String tituloOriginal;
    @Json(name = "overview")
    private final String detalheFilme;

    public FilmeResponse(String caminhoPoster, String tituloOriginal, String detalheFilme) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
        this.detalheFilme = detalheFilme;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getDetalheFilme() {
        return detalheFilme;
    }
}
