import java.util.Scanner;

public class MeuNum {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double num1, num2;
        double media;
        System.out.println("Digite o primeiro numero: ");
        num1 = leitor.nextInt();
        System.out.println("Digite o segundo numero: ");
        num2 = leitor.nextInt();
        media = (num1 + num2)/2f;
        System.out.println("Sua media é: " + media);



    }
}
