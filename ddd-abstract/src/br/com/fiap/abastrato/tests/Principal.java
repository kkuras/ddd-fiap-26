package br.com.fiap.abastrato.tests;

import br.com.fiap.abastrato.models.Alimentacao;
import br.com.fiap.abastrato.models.Diaria;
import br.com.fiap.abastrato.models.Transporte;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Alimentacao refeicoes = new Alimentacao();
        Transporte veiculos = new Transporte();
        Diaria diaria = new Diaria();

        int op = 10;
        while (op != 0){
            System.out.println("Digite:\n1 - Alimentação\n2 - Transporte\n3 - Diaria\n0 - Sair");
            op = leitor.nextInt();
            switch (op) {
                case 1:
                    int opcao;
                    do {
                        System.out.println("1- cadastrar despesa\n2- calcular despesa\n3- apresentar despesa\n4 - voltar");
                        opcao = leitor.nextInt();
                        if (opcao == 1) {
                            refeicoes.cadastrarDespesa("bem legal", "coxihnha", 30);
                            System.out.println("despesa cadastrada");
                        } else if(opcao == 2){
                            System.out.println(refeicoes.calcularDespesa());
                        } else if (opcao == 3){
                            System.out.println(refeicoes.listarDespesa());
                        }
                        else {
                            System.out.println("Voltando para o menu principal ....");
                        }
                    } while (opcao != 4);
                    break;
                case 2:
                    do {
                        System.out.println("1- cadastrar despesa\n2- calcular despesa\n3- apresentar despesa\n4 - voltar");
                        opcao = leitor.nextInt();
                        if (opcao == 1) {
                            veiculos.cadastrarDespesa("corrida louca", 50, 15);
                            System.out.println("despesa cadastrada");
                        } else if(opcao == 2){
                            System.out.println(veiculos.calcularDespesa());
                        } else if (opcao == 3){
                            System.out.println(veiculos.listarDespesa());
                        }
                        else {
                            System.out.println("Voltando para o menu principal ....");
                        }
                    } while (opcao != 4);
                    break;
                case 3:
                    do {
                        System.out.println("1- cadastrar despesa\n2- calcular despesa\n3- apresentar despesa\n4 - voltar");
                        opcao = leitor.nextInt();
                        if (opcao == 1) {
                            diaria.cadastrarDespesa("diaria louca", 5);
                            System.out.println("despesa cadastrada");
                        } else if(opcao == 2){
                            System.out.println(diaria.calcularDespesa());
                        } else if (opcao == 3){
                            System.out.println(diaria.listarDespesa());
                        }
                        else {
                            System.out.println("Voltando para o menu principal ....");
                        }
                    } while (opcao != 4);
                    break;
            }
        }

    }
}
