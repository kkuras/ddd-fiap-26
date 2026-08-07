package br.com.fiap.escolaMusica.models;

import br.com.fiap.escolaMusica.interfaces.Exibivel;

public class Aluno extends Pessoa {

    private int idade;

    public Aluno(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    @Override
    public void exibirInformacoes() {

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
