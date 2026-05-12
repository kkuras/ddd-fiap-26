package calculadora;

public class Calculadora {
    // classe de modelagem
    double numero1;
    double numero2;
    double resultado;
    double resultadoDiv;
    public void exibirResultado() {
        System.out.println("Seu numero é: " + resultado);
    }
    public void somar() {
        resultado = numero1 + numero2;
    }

    // metodo com retorno
    public double subtrair() {
        return numero1 - numero2;
    }

    // metodo com parametro
    public String exibir(double valor, String operacao) {
        return operacao + " = " + valor;
    }

    // metodo com retorno com parametro
    public double multiplicar() {
        return numero1 * numero2;
    }
    public String exibirMulti(double valor, String operacao) {
        return operacao + " = " + valor;
    }

    //metodo sem retorno sem parametro
    public void divisao() {
        resultadoDiv = numero1 / numero2;
    }
    public void exibirDiv() {
        System.out.println("O Resultado da divisao é = " + resultadoDiv);
    }
    // metodo multiplicador e dividir
    public String dividir(){
        if(numero2 > 0) {
            resultado = numero1 / numero2;
            return"Divisao = " + resultado;
        }
        return "Nao é possivel fazer a divisao";
    }
}
