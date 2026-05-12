package br.com.fiap.abastrato.models;

public class Diaria extends Despesa{

    private double qtdDiaria;


    public void cadastrarDespesa(String descricao, double qtdDiaria) {
        super.cadastrarDespesa(descricao);
        this.qtdDiaria = qtdDiaria;

    }

    @Override
    public double calcularDespesa() {
        return valorTotal = qtdDiaria * 50;
    }

    @Override
    public String listarDespesa() {
        return "Descrição: " + descricao +
                "\nQuantidade de diárias: " + qtdDiaria +
                "\nValor total: " + valorTotal;
    }

    public double getQtdDiaria() {
        return qtdDiaria;
    }

    public void setQtdDiaria(double qtdDiaria) {
        this.qtdDiaria = qtdDiaria;
    }
}
