package br.com.fiap.interfaces.models;

public class Veiculo{

    private double valorHora;
    private double valorAdicional;
    private double horas;

    public double doTotal() {
        return valorHora + valorAdicional * (horas - 1);
    }

    public String doViewCupom() {
        return "nao sei oq colocar aqui";
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }
}
