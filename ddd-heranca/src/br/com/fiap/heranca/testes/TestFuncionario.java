package br.com.fiap.heranca.testes;

import br.com.fiap.heranca.models.Gerente;
import br.com.fiap.heranca.models.Vendedor;

import java.util.Scanner;

public class TestFuncionario {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        //Vendedor vendedor = new Vendedor();
        Gerente gerente = new Gerente();

        gerente.setNome("laele");
        gerente.setSalario(500);

        System.out.println("qual o valor da venda?");
        gerente.calculaBonificacao();
        System.out.println(gerente.calculaBonificacao());
    }
}
