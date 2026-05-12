package br.com.fiap.encapsulamento.tests;

import br.com.fiap.encapsulamento.models.Investimento;

import java.util.Scanner;

public class TestInvestimento {
    public static void main(String[] args) {
        Investimento in = new Investimento();
        Scanner leitor = new Scanner(System.in);
        Scanner leitoTexto = new Scanner(System.in);

        System.out.println("digite o valor");
        in.setValor(leitor.nextDouble());
        System.out.println("digite o tipo 'poupança' ou 'renda fixa' ");
        in.setTipo(leitoTexto.next());

        System.out.println("o valor corrigido é " + in.correcao());
    }
}
