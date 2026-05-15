package br.com.fiap.streaming.models;

import java.util.List;

public class Serie extends Titulo{

    private int numeroTemporada;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;
    private List<Temporada> temporadas;

    @Override
    public String toString() {
        return super.toString();
    }

    public void exibirFichaTecnica() {

    }

    public void somarNotas(double nota) {

    }
}
