package br.com.fiap.streaming.models;

import br.com.fiap.streaming.interfaces.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private double avaliacao;
    private int totalVisualizacao;
    private Integer numeroTemporada;

    public Episodio(int numero, String nome, double avaliacao, int totalVisualizacoes) {
        this.numero = numero;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.totalVisualizacao = totalVisualizacao;
    }

    public Episodio(int numeroTemporada, Episodio d) {
        this.numeroTemporada = numeroTemporada;
        this.numero = d.numero;
        this.nome = d.nome;
        this.avaliacao = d.avaliacao;
        this.totalVisualizacao = d.totalVisualizacao;
    }

    @Override
    public String toString() {
        return String.format("  Ep.%02d - %-30s | Avaliação: %.1f | Views: %d",
                numero, nome, avaliacao, totalVisualizacao);
    }


    public int getClassificacao() {
        return (int) avaliacao;
    }

    public Integer getNumeroTemporada() {
        return numeroTemporada;
    }
    public void setNumeroTemporada(Integer n) {
        this.numeroTemporada = n;
    }

    public int getNumero() {
        return numero;
    }
    public String getNome() {
        return nome;
    }
    public double getAvaliacao() {
        return avaliacao;
    }
    public int getTotalVisualizacoes() {
        return totalVisualizacao;
    }

}
