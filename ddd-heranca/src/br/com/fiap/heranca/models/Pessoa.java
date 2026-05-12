package br.com.fiap.heranca.models;

public class Pessoa {

    protected String nome;
    protected String cpf;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String exibirDados() {
        return "nome: " + nome + " - cpf: " + cpf + "\nemail: " + email;
    }
}
