package calculadora;

import java.util.Scanner;

public class TesteCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner leitor = new Scanner(System.in);

        System.out.println("calculadora.Calculadora");
        System.out.println("Digite o primeiro numero: ");
        calculadora.numero1 = leitor.nextDouble();
        System.out.println("Digite o segundo numero:");
        calculadora.numero2 = leitor.nextDouble();
        calculadora.somar();
        //calculadora.exibirResultado();

        //metodos para chamar um metodo com retorno
        //System.out.println("substrair: " + calculadora.subtrair());
        double subs = calculadora.subtrair();
        //System.out.println(subs);
        System.out.println(calculadora.exibir(calculadora.resultado, "Soma"));
        System.out.println(calculadora.exibir(subs, "Substração"));

        // multiplicacao
        double multi = calculadora.multiplicar();
        System.out.println(calculadora.exibirMulti(multi, "Multiplicação"));
        // divisao
        //calculadora.divisao();
        //calculadora.exibirDiv();
        System.out.println(calculadora.dividir());


    }
}