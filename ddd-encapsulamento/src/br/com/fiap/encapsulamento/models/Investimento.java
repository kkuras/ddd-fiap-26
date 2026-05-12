package br.com.fiap.encapsulamento.models;

public class Investimento {

    private double valor;
    private String tipo;


    public double correcao() {
        if (tipo.equalsIgnoreCase("poupança")) {
            return valor + (valor * 0.03);
        } else if (tipo.equalsIgnoreCase("renda fixa")) {
            return valor + (valor * 0.04);
        }
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getValor() {
        return valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
}
