package br.com.fiap.cineFiap.exceptions;

public class FilmeNaoEncontradoException extends RuntimeException {
    public FilmeNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
