package fiap.com.br.agendaweb.models;

public class Aluno {

    String nome;
    int id;

    public Aluno(String nome, int id) {

        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
