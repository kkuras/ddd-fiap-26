package br.fiap.models;

import br.fiap.interfaces.Reproduzivel;

public class Musica implements Reproduzivel {

    private String nome;
    private String artista;
    private String genero;
    private int duracao;
    private int anoLançamento;

    public String exibir() {
        return nome;
    }

    @Override
    public String toString() {
        return "Musica: " + nome + "artista" + artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoLançamento() {
        return anoLançamento;
    }

    public void setAnoLançamento(int anoLançamento) {
        this.anoLançamento = anoLançamento;
    }

    public int getDuracao() {
        if(duracao <= 0) {
            System.out.println("ta mt grande");
        }
        return 0;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void reprodzir() {

    }

    @Override
    public void parar() {

    }

    public Musica(String nome, String artista, String genero, int duracao, int anoLançamento) {
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
        this.duracao = duracao;
        this.anoLançamento = anoLançamento;
    }
}
