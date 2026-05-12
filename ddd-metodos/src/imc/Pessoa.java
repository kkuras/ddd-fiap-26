package imc;

public class Pessoa {

    String nome;
    double altura;
    double peso;

    public double calcularImc() {
         return peso / (altura * altura);
    }

    public String exibirClassificacao() {
        double imc = calcularImc();
        if (imc < 18.5) {
            return ("Abaixo do peso");
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Acima do peso";
        } else if (imc < 35) {
            return "Obesidade 1";
        } else if (imc < 40) {
            return "Obesidade 2";
        } else {
            return "Obesidade 3";
        }
    }
}
