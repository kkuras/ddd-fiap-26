package br.com.fiap.abastrato.models;

import br.com.fiap.abastrato.enums.StatusVeiculo;

public class Caminhao extends Veiculo{

    private double capacidadeCarga;

    public Caminhao(String placa, double nivelCombustivel, StatusVeiculo status, double capacidadeCarga) {
        super(placa, nivelCombustivel, status);
        this.capacidadeCarga = capacidadeCarga;
    }



    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public boolean validarAutonomia(double km) {

        return getNivelCombustivel() * 2 >= km;
    }
}
