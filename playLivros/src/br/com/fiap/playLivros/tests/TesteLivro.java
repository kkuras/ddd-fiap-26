package br.com.fiap.playLivros.tests;

import br.com.fiap.playLivros.model.Editora;
import br.com.fiap.playLivros.model.Livro;

import java.util.Scanner;

public class TesteLivro {
    public static void main(String[] args) {

        Livro livro = new Livro("Java 2 ");
        Editora editora = new Editora();
        editora.nome = "novatec ";
        System.out.println(livro.titulo);
        livro.editora = editora;
        System.out.print("livro " + livro.titulo + "foi opublicado pela " + livro.editora.nome);

        Livro livroPreferido = new Livro("UML", 50);

    }
}
