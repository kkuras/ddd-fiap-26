package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDAO;
import br.com.fiap.agenda.models.Contato;

import java.util.Scanner;

public class TesteDeletar {
    static void main() {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);
        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();

        System.out.println("digita ai");
        contato.setId(leitorNum.nextInt());
        dao.deletar(contato.getId());
        System.out.println("registro excluido");
    }
}
