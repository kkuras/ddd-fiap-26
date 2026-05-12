package eletrodomestico;

import java.util.Scanner;

public class EletroDomestico {
    String nome;
    double potenciaWatts;
    double horasPorDia;

    public double calcularConsumoDiario() {
        return (potenciaWatts * horasPorDia) / 1000;
    }
    public double calcularCustoMensal(double valorKwh) {
        return calcularConsumoDiario() * 30 * valorKwh;
    }
    public void exibirDados() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual é o seu eletrodomestico: ");
        nome = leitor.nextLine();
        System.out.println("Quantos watts utiliza: ");
        potenciaWatts = leitor.nextDouble();
        System.out.println("Quantas horas por dia: ");
        horasPorDia = leitor.nextDouble();
        System.out.println("Seu custo mensal é R$" + calcularCustoMensal(0.70));
    }
}
