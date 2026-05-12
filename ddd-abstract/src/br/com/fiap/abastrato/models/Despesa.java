package br.com.fiap.abastrato.models;

public abstract class Despesa {

    protected String descricao;
    protected double valorTotal;

    public void cadastrarDespesa(String descricao) {
    }

    public abstract double calcularDespesa();

    public abstract String listarDespesa();
}
