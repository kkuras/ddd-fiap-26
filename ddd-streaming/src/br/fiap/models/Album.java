package br.fiap.models;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String nome;
    private String artista;
    private int anoLancamento;
    private int duracao;

    private List<Musica> musicas = new ArrayList<>();

    public void adicionarMusica(Musica musica) {
        // metodo para adionar um item a lista: add
        musicas.add(musica);
        duracao += musica.getDuracao();
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
        duracao -= musica.getDuracao();
    }

    public void cancelarDuracao() {
        for (int i=0; i< musicas.size(); i++) {
            duracao += musicas.get(i).getDuracao();
        }

        for (Musica musica : this.musicas) {
            duracao += musica.getDuracao();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Album(List<Musica> musicas, int anoLancamento, String artista, String nome) {
        this.musicas = musicas;
        this.anoLancamento = anoLancamento;
        this.artista = artista;
        this.nome = nome;
    }

    public void calcularduracao() {
        for (int i=0; i<musicas.size(); i++) {
            duracao += musicas.get(i).getDuracao();
        }

        for (Musica musica : this.musicas) {
            duracao += musica.getDuracao();
        }
    }

    public void exibirLista() {
        System.out.println("tamnho da lista:" + musicas.size());
        System.out.println("exibindo a lista com foreach");
        musicas.forEach(musica -> {
            System.out.println("nome: " + musica.getNome());
            System.out.println("\nartista: " + musica.getArtista());
        });

        System.out.println("==================");
        System.out.println("primeiro elemento: " + musicas.get(0));
        System.out.println("\nexibindo a lista com foreach usando tostring");


        musicas.forEach(musica -> System.out.println(musica));
        musicas.forEach(System.out::println);
    }



}
