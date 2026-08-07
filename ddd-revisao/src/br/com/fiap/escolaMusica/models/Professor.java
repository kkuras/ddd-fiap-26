package br.com.fiap.escolaMusica.models;

import br.com.fiap.escolaMusica.enums.Instrumentos;
import br.com.fiap.escolaMusica.interfaces.Exibivel;

public class Professor extends Pessoa{

    private String instrumentos;

    public Professor(String nome, String cpf, String email, String instrumentos) {
        super(nome, cpf, email);
        this.instrumentos = instrumentos;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("============== DETALHES DO PROFESSOR ==============");
        System.out.println("Nome:          " + getNome());
        System.out.println("CPF:           " + getCpf());
        System.out.println("Email:         " + getEmail());
        System.out.println("Especialidade: " + instrumentos);
        System.out.println("===================================================");
    }

    public String getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(String instrumentos) {
        this.instrumentos = instrumentos;
    }
}
