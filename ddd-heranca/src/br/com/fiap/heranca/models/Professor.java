package br.com.fiap.heranca.models;

public class Professor extends Pessoa{

    private String ctps;
    private double valorHora;
    private double qtdHoras;

    public double calcularSalario() {
        return valorHora * qtdHoras;
    }
    //sobrescrita de metodo do pai mas com implementação diferente

    public String exibirDados() {
        return super.exibirDados() +
                "\nCTPS: " + ctps + "\nSalario do professor: " + calcularSalario();
    }

    public void exibirProfessor() {
        System.out.println(nome + " cpf: " + cpf);
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public double getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(double qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
