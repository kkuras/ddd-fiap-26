package br.com.fiap.encapsulamento.tests;

import br.com.fiap.encapsulamento.models.ContaBancaria;
import br.com.fiap.encapsulamento.models.ContaCorrente;

import java.util.Scanner;

public class TesteContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("123855", "Claudio");
        Scanner leitor = new Scanner(System.in);
        ContaCorrente corrente = new ContaCorrente("1232235", "cadwa");

        corrente.getLimite();

        System.out.println("Digite o valor para depositar");
        conta.depositar(leitor.nextDouble());

        System.out.println("Digite o valor para sacar");
        conta.sacar(leitor.nextDouble());


        System.out.println("Nome do titular: " + conta.getTitular());
        System.out.println("Digite o nome do novo usuario: ");
        conta.setTitular(leitor.next());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Numero conta: " + conta.getNumeroConta());
        System.out.println("Nome do titular: " + conta.getTitular());




    }
}
