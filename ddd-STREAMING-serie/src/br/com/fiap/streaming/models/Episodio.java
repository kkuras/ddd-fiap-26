package br.com.fiap.streaming.models;

import br.com.fiap.streaming.interfaces.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private double avaliacao;
    private int totalVisualizacao;
    private Integer numeroTemporada;

    public Episodio(int numeroTemporada, Episodio d) {

    }

    public Episodio(int numero, String nome, double avaliacao,int totalVisualizacao) {

    }

    public Integer getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(Integer numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    @Override
    public int getClassificacao() {
        return 0;
    }

}
