package br.com.fiap.escolaMusica.models;

import br.com.fiap.escolaMusica.enums.Instrumentos;
import br.com.fiap.escolaMusica.interfaces.Exibivel;

public class Professor extends Pessoa{

    private Instrumentos instrumentos;

    public Professor(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    @Override
    public void exibirInformacoes() {

    }
}
