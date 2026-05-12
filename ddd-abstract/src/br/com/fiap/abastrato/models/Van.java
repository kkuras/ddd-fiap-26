package br.com.fiap.abastrato.models;

import br.com.fiap.abastrato.enums.StatusVeiculo;

public class Van extends Veiculo{
    private boolean refrigerada;

    public Van(String placa, double nivelCombustivel, StatusVeiculo status, boolean refrigerada) {
        super(placa, nivelCombustivel, status);
        this.refrigerada = refrigerada;
    }


    public boolean isRefrigerada() {
        return refrigerada;
    }

    public void setRefrigerada(boolean refrigerada) {
        this.refrigerada = refrigerada;
    }

    @Override
    public boolean validarAutonomia(double km) {
        return (getNivelCombustivel() >= km);
    }
}
