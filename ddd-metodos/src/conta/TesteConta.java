package conta;

import java.util.Scanner;

public class TesteConta {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ContaBancaria contaBancaria = new ContaBancaria();

        System.out.println("Digite o nome do titular da conta: ");
        contaBancaria.titular = leitor.nextLine();
        System.out.println("Digite o saldo: ");
        contaBancaria.saldo = leitor.nextDouble();
        contaBancaria.depositar(50);
        contaBancaria.depositar(10);
        contaBancaria.sacar(30);
        contaBancaria.sacar(50);
        contaBancaria.sacar(100);
        System.out.println(contaBancaria.verificarStatus());
        System.out.println("Saldo final: " + contaBancaria.saldo);
    }
}
