package br.com.fiap.heranca.testes;

import br.com.fiap.heranca.models.Professor;

public class TesteProfessor {
    public static void main(String[] args) {

        Professor professor = new Professor();
        professor.setNome("laele");
        professor.setCtps("123");
        professor.setQtdHoras(40);
        professor.setCpf("523");
        professor.setEmail("wda@gmail.com");
        professor.setValorHora(35);

        double salario = professor.calcularSalario();
        System.out.println(professor.exibirDados());
    }



}
