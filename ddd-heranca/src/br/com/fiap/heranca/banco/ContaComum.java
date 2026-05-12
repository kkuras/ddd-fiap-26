package br.com.fiap.heranca.banco;

import java.time.LocalDate;
import java.util.Random;

public class ContaComum {

    public Long geradorContas() {
        Random random = new Random();

        return random.nextLong(999999);

    }

    protected Long nroConta;
    protected LocalDate dtAbertura;
    protected LocalDate dtEncerramento;
    protected SituacaoEnum situacao;
    protected int senha;
    protected double saldo;
    protected Cliente cliente;

    public Long abrirConta(int senha){

        this.senha = senha;
        this.nroConta = geradorContas();
        this.dtAbertura = LocalDate.now();
        this.situacao = SituacaoEnum.ATIVA;
        return nroConta;
    }

    public boolean validarSenha(int senha) {
        if (senha == this.senha) {
            return true;
        } else {
            return false;
        }
    }

    public String sacarValor(double valor) {
        if (valor <= this.saldo) {
            saldo = saldo - valor;
            return "Saque efetuado com sucesso";
        }else {
            return "Saque não efetuado, saldo insuficiente";
        }
    }

    public void depositarValor(double valor, Long nroConta) {
        if (this.nroConta.equals(nroConta)) {
            saldo += valor;
        }

    }

    public String encerrarConta(Long nroConta) {
        if (this.nroConta = nroConta) {
            this.situacao = SituacaoEnum.INATIVA;
            this.saldo = 0;
        } else {
            return "Numero de conta errado";
        }

    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public Long getNroConta() {
        return nroConta;
    }

    public void setNroConta(Long nroConta) {
        this.nroConta = nroConta;
    }

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(LocalDate dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
