package br.com.fiap.interfaces.models;

public class Segurado extends Veiculo implements ISeguroService{

    private double seguro;

    public Segurado(double seguro) {
        this.seguro = seguro;
    }

    public double doTotal() {
        return super.doTotal() - doDesconto();
    }

    public String doViewCupom() {
        return super.doViewCupom() + "\nsei la";
    }

    @Override
    public double doDesconto() {
        return super.doTotal() * seguro / 100;
    }

}
