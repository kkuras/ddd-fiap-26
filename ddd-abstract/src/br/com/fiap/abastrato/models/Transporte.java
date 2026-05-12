package br.com.fiap.abastrato.models;

public class Transporte extends Despesa{

    private double kmPercorrida;
    private double valorPedagio;


    public void cadastrarDespesa(String descricao, double kmPercorrida, double valorPedagio) {
        super.cadastrarDespesa(descricao);
        this.kmPercorrida = kmPercorrida;
        this.valorPedagio = valorPedagio;
    }

    @Override
    public double calcularDespesa() {
        return valorTotal = (kmPercorrida * 3) + valorPedagio;
    }

    @Override
    public String listarDespesa() {
        return "Descrição: " + descricao +
                "\nKm percorrida: " + kmPercorrida +
                "\nValor pedágios: " + valorPedagio +
                "\nValor total: " + valorTotal;
    }

    public double getKmPercorrida() {
        return kmPercorrida;
    }

    public void setKmPercorrida(double kmPercorrida) {
        this.kmPercorrida = kmPercorrida;
    }

    public double getValorPedagio() {
        return valorPedagio;
    }

    public void setValorPedagio(double valorPedagio) {
        this.valorPedagio = valorPedagio;
    }
}
