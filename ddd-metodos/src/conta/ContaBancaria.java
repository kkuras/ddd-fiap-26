package conta;

public class ContaBancaria {
    String titular;
    double saldo;

    public void depositar(double valor) {
        saldo = saldo + valor;
    }
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
        } else {
            System.out.println("Não foi possivel fazer um saque");
        }
    }
    public String verificarStatus() {
        if ( saldo > 0){
            return "Conta positiva";
        } else if (saldo == 0) {
            return "Conta Zerada";
        } else {
            return "Conta em debito";
        }
    }
}
