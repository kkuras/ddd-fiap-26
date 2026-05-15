package br.com.fiap.streaming.models;

import br.com.fiap.streaming.interfaces.Classificavel;

public class Filme extends Titulo implements Classificavel {

    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void somarNotas(double nota) {

    }

    @Override
    public int getClassificacao() {
        return 0;
    }
}
