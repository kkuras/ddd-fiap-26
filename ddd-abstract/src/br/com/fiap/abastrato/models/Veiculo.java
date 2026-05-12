package br.com.fiap.abastrato.models;

import br.com.fiap.abastrato.enums.StatusVeiculo;

public abstract class Veiculo {

    private String placa;
    private double nivelCombustivel;
    private StatusVeiculo status;

    public Veiculo(String placa, double nivelCombustivel, StatusVeiculo status) {
        this.placa = placa;
        this.nivelCombustivel = nivelCombustivel;
        this.status = status;
    }

    public abstract boolean validarAutonomia(double km);

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivelCombustivel) {
        this.nivelCombustivel = nivelCombustivel;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }
}
