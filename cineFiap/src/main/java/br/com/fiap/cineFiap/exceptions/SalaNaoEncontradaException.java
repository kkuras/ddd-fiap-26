package br.com.fiap.cineFiap.exceptions;

public class SalaNaoEncontradaException extends RuntimeException{
    public SalaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
