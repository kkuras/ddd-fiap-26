package br.com.fiap.encapsulamento.tests;

import br.com.fiap.encapsulamento.models.Triangulo;

import java.util.Scanner;

public class TestTriangulo {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo();
        Scanner scanner = new Scanner(System.in);

        triangulo.setX(4);
        triangulo.setY(6);
        triangulo.setZ(3);

        System.out.println("Digite o X do triangulo");
        triangulo.setX(scanner.nextDouble());
        System.out.println("Digite o Y do triangulo");
        triangulo.setY(scanner.nextDouble());
        System.out.println("Digite o Z do triangulo");
        triangulo.setZ(scanner.nextDouble());
        System.out.println(triangulo.valida());


    }
}
