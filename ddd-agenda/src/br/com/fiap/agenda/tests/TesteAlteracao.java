package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDAO;
import br.com.fiap.agenda.models.Contato;

import java.util.Scanner;

public class TesteAlteracao {
    static void main() {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);

        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();

        System.out.println("=====alteracao=====");
        System.out.println("Digite o codigo para alterar");
        contato.setId(leitorNum.nextInt());

        System.out.println("Digite o nome para alterar");
        contato.setNome(leitor.nextLine());

        System.out.println("Digite o celular para alterar");
        contato.setCelular(leitor.nextLine());

        System.out.println("Digite o email para alterar");
        contato.setEmail(leitor.nextLine());

        System.out.println("Digite o instragram para alterar");
        contato.setInstagram(leitor.nextLine());

        System.out.println("Digite o tipo do contado para alterar: AMIGO, FAMILIAR, PROFISSIONAL");
        contato.setTipo(leitor.nextLine());

        dao.alterar(contato);
        System.out.println("contato foi alterado com sucesso");
    }
}
