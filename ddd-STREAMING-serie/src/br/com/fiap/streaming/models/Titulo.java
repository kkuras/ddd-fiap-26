package br.com.fiap.streaming.models;

import br.com.fiap.streaming.enums.ClassificacaoEnum;

public abstract class Titulo {

    private String nome;
    private int anodeLancamento;
    private int duracaoEmMinutos;
    private double somaAvaliacao;
    private int totalAvaliacao;
    private ClassificacaoEnum classificacaoIndicativa;

    public Titulo(String nome, int anoDeLancamento, int duracaoEmMinutos,
                  ClassificacaoEnum classificacaoIndicativa) {
        this.nome = nome;
        this.anodeLancamento= anoDeLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.somaAvaliacao = 0;
        this.totalAvaliacao = 0;
    }

    public void exibirFichaTecnica() {
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lançamento: " + anodeLancamento);
        System.out.println("Duração: " + duracaoEmMinutos + " min");
        System.out.println("Classificação Indicativa: " + classificacaoIndicativa.getClassificacao() + " anos");
        if (totalAvaliacao > 0) {
            System.out.printf("Avaliação Média: %.1f%n", somaAvaliacao / totalAvaliacao);
        }

    }


    public void somarNotas(double nota) {
        this.somaAvaliacao += nota;
        this.totalAvaliacao++;
    }

    public String getNome() {
        return nome;
    }
    public int getAnoDeLancamento() {
        return anodeLancamento;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public double getSomaAvaliacao() {
        return somaAvaliacao;
    }
    public int getTotalAvaliacoes() {
        return totalAvaliacao;
    }
    public ClassificacaoEnum getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }
}
