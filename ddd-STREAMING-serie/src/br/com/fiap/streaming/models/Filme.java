package br.com.fiap.streaming.models;

import br.com.fiap.streaming.enums.ClassificacaoEnum;
import br.com.fiap.streaming.interfaces.Classificavel;

public class Filme extends Titulo implements Classificavel {

    private String diretor;

    public Filme(String nome, int anoDeLancamento, int duracaoEmMinutos,
                 ClassificacaoEnum classificacaoIndicativa, String diretor) {
        super(nome, anoDeLancamento, duracaoEmMinutos, classificacaoIndicativa);
        this.diretor = diretor;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public void somarNotas(double nota) {
        super.somarNotas(nota);
    }



    @Override
    public void exibirFichaTecnica() {
        System.out.println("=== FILME ===");
        super.exibirFichaTecnica();
        System.out.println("Diretor: " + diretor);
    }

    @Override
    public String toString() {
        return getNome() + " (" + getAnoDeLancamento() + ") - " + getDuracaoEmMinutos() + " min - Dir: " + diretor;
    }

    @Override
    public int getClassificacao() {
        return 0;
    }
}
