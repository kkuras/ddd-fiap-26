package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ConnectionFactory;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("eu como coco dos bancos de dados");
        if (ConnectionFactory.obterconexao() == null) {
            System.out.println("deu erro");
        } else {
            System.out.println("conecto dnv agora foi tu conseguiu comer os coco dos bancos");
        }
    }
}
