package br.com.fiap.escolaMusica.models;

import br.com.fiap.escolaMusica.enums.NivelCurso;
import br.com.fiap.escolaMusica.interfaces.Exibivel;

import java.util.ArrayList;
import java.util.List;

public class Curso implements Exibivel {

    private String nome;
    private NivelCurso nivel;
    private Professor professorResponsavel;
    private List<Aluno> listaAluno;

    public Curso(String nome, NivelCurso nivel,
                 Professor professorResponsavel) {
        this.nome = nome;
        this.nivel = nivel;
        this.professorResponsavel = professorResponsavel;
        this.listaAluno = new ArrayList<>();
    }


    public void matricularAluno(Aluno aluno) {
        if (!this.listaAluno.contains(aluno)) {
            listaAluno.add(aluno);
        }
    }

    public void cancelarAluno(Aluno aluno) {
        if (aluno != null && this.listaAluno.contains(aluno)) {
            this.listaAluno.remove(aluno);
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelCurso getNivel() {
        return nivel;
    }

    public void setNivel(NivelCurso nivel) {
        this.nivel = nivel;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public List<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("detalhes curso");
        System.out.println("nome: " + nome);
        System.out.println("nivel: " + nivel);
        System.out.println("professor responsavel: " + professorResponsavel);
        System.out.println("numero de alunos: " + listaAluno.size());
        System.out.println("alunos matriculados: ");
        if (listaAluno.isEmpty()) {
            System.out.println("nenhum aluno cadastrado"    );
        }
        else{
            System.out.println("-------------------");
            for (Aluno aluno : listaAluno) {
                System.out.println(" = " + aluno.getNome() + " ( " + aluno.getIdade() + " ) ");
            }

        }

    }
}
