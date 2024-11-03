package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

public class VeiculosTO {
    @NotNull private String placa;
    @NotNull private String modelo;
    private String cor;
    @NotNull private String marca;
    @NotNull private String cpf;

    public VeiculosTO() {
    }

    public VeiculosTO(String placa, String modelo, String cor, String marca, String cpf) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.cpf = cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}