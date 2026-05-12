package imc;

import java.util.Scanner;

public class TesteIMC {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Teste IMC");
        System.out.println("Digite seu nome: ");
        pessoa.nome = leitor.nextLine();
        System.out.println("Digite sua altura: ");
        pessoa.altura = leitor.nextDouble();
        System.out.println("Digite seu peso: ");
        pessoa.peso = leitor.nextDouble();

        System.out.println("Seu nome é: " + pessoa.nome);
        System.out.println("Seu IMC é: " + pessoa.calcularImc());
        System.out.println("Sua classificação do IMC é: " + pessoa.exibirClassificacao());

    }
}
