package br.com.fiap.interfaces.models;

public class BalancoDiario {
    private static int qtdeCarros;
    private static double total;

    public void doAdd(Veiculo obj) {
        qtdeCarros++;
        total += obj.doTotal();

    }

    public String doGerarRelatorio() {
        return "carros: " + qtdeCarros +
                "\ntotal:" + total;
    }
}
