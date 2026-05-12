package br.com.fiap.abastrato.models;

public class Alimentacao extends Despesa{

    private String nomeRestaurante;
    private int qtdRefeicao;


    public void cadastrarDespesa(String descricao, String nome, int qtdRefeicao) {
        super.cadastrarDespesa(descricao);
        this.nomeRestaurante = nome;
        this.qtdRefeicao = qtdRefeicao;
    }

    @Override
    public double calcularDespesa() {

        return valorTotal = qtdRefeicao * 18;
    }

    @Override
    public String listarDespesa() {
        return "Descrição: " + descricao +
                "\nRestaurante: " + nomeRestaurante +
                "\nQuantidade de refeições: " + qtdRefeicao +
                "\nValor total: " + valorTotal;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public int getQtdRefeicao() {
        return qtdRefeicao;
    }

    public void setQtdRefeicao(int qtdRefeicao) {
        this.qtdRefeicao = qtdRefeicao;
    }
}
