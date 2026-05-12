package br.com.fiap.heranca.banco;

public class ContaEspecial extends  ContaComum{

    private double limite;

    public Long abrirConta(int senha, double limite) {
        this.limite = limite;
        return super.abrirConta(senha);
    }

    public String sacarValor(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            return "saque efetuado com sucesso";
        } else if (valor <= saldo + limite) {
            limite = limite - (saldo - valor);
            saldo = 0;
            return "saque efetuado, com o uso do limite";
        } else {
            return "nao foi efetuado o saldo";
        }
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
