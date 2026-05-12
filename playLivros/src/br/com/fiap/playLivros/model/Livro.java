package br.com.fiap.playLivros.model;

public class Livro {
    public String titulo;
    public String autor;
    public double preco;
    public Editora editora;
    public int pagina;
    public String resumo;

    public Livro(String titulo){
        this.titulo = titulo;
    }
    public Livro(String titulo, double preco){
        this.titulo = titulo;
        this.preco = preco;
    }
    public Livro(String titulo, double preco, String autor){
        this.titulo = titulo;
        this.preco = preco;
        this.autor = autor;
    }
}
