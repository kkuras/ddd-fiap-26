package br.com.fiap.encapsulamento.models;

public class Triangulo {

    private double x;
    private double y;
    private double z;

    public String valida() {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "Os valores não formam um triângulo";
        } else if ((x == y && x == z)) {
            return "Triângulo Equilátero";
        } else if (x != y && x != z && y != z) {
            return "Triângulo Escaleno";
        } else {
            return "Triângulo Isosceles";
        }
    }

    public void setX(double x) {
        if (x < 0){
            System.out.println("nao é permitido valores negativos");
            x = x * -1;
        }
        this.x = x;
    }
    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double getY() {
        return y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public double getZ() {
        return z;
    }
}

