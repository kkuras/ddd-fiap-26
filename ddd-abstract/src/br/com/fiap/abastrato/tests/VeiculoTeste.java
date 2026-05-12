package br.com.fiap.abastrato.tests;

import br.com.fiap.abastrato.models.Caminhao;
import br.com.fiap.abastrato.enums.StatusVeiculo;
import br.com.fiap.abastrato.models.Van;

public class VeiculoTeste {

    public static void main(String[] args) {
        Van van = new Van("ABC-1234", 50.0, StatusVeiculo.DISPONIVEL, false);
        Caminhao caminhao = new Caminhao("XYZ-5678", 50.0, StatusVeiculo.DISPONIVEL, 5000);

        System.out.println(van.validarAutonomia(300));      // true  (precisa 30L, tem 50L)
        System.out.println(caminhao.validarAutonomia(300)); // false (precisa 90L, tem 50L)
    }
}
