package br.com.fiap.encapsulamento.models;

public class ContaBancaria {

    private String numeroConta;
    private double saldo;
    private String titular;

    // construtor nao devolve nada
    public ContaBancaria(String numeroConta , String titular ) {
        // serve para referenciar o atributo do objeto,
        // diferenciando do parâmetro que tem o mesmo nome
        this.numeroConta = numeroConta;
        this.titular = titular;
    }
    public void depositar(double valor) {
        if (valor <= -1) {
            System.out.println("erro, nao pode depositar saldo negativo");
        } else {
            saldo += valor;
        }
    }
    public void sacar(double valor) {
        if(valor <= -1 || valor >= saldo) {
            System.out.println("o valor deve ser positivo | o valor nao deve exceder o saldo");
        } else {
            saldo -= valor;
        }
    }

    public double getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
}
