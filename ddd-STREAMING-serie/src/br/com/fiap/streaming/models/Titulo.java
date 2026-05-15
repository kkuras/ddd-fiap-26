package br.com.fiap.streaming.models;

import br.com.fiap.streaming.enums.ClassificacaoEnum;

public abstract class Titulo {

    private String nome;
    private int anodeLancamento;
    private int duracaoEmMinutos;
    private double somaAvaliacao;
    private int totalAvaliacao;
    private ClassificacaoEnum classificacaoEnum;

    public void exibirFichaTecnica() {

    }

    public void somarNotas(double nota) {

    }
}
