package br.com.fiap.streaming.models;

import java.util.List;

public class Temporada {

    private int numeroTemporada;
    private List<Episodio> episodios;

    public Temporada(int numeroTemporada, List<Episodio> episodios) {
        this.numeroTemporada = numeroTemporada;
        this.episodios = episodios;
    }

    public int getNumeroTemporada()         {
        return numeroTemporada;
    }
    public List<Episodio> getEpisodios()    {
        return episodios;
    }

    @Override
    public String toString() {
        return "Temporada " + numeroTemporada + " (" + episodios.size() + " episódios)";
    }
}
