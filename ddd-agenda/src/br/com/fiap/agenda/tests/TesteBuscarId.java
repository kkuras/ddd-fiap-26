package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDAO;
import br.com.fiap.agenda.models.Contato;

import java.util.Scanner;

public class TesteBuscarId {
    public static void main(String[] args) {

        Scanner leitornum = new Scanner(System.in);

        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();

        System.out.println("consulta por id: ");

        System.out.println("digite o id: ");
        int id = leitornum.nextInt();
        contato = dao.buscarID(id);
        System.out.println(contato);
    }
}
