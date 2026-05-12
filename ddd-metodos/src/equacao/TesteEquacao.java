package equacao;

import java.util.Scanner;

public class TesteEquacao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Equacao equacao = new Equacao();
        System.out.println("Digite o CoeA: ");
        equacao.coeA = leitor.nextInt();
        System.out.println("Digite o CoeB: ");
        equacao.coeB = leitor.nextInt();
        System.out.println("Digite o CoeC: ");
        equacao.coeC = leitor.nextInt();
        System.out.println("Valor do delta é: " + equacao.calcDelta());
        System.out.println("Raizes existentes: " + equacao.raiz());
    }
}
