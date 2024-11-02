package br.com.fiap.to;

public class VeiculosTO {
    private Long id_veiculo;
    private String placa;
    private String modelo;
    private String cor;
    private String marca;
    private Long id_cliente;

    public VeiculosTO() {
    }

    public VeiculosTO(Long id_veiculo, String placa, String modelo, String cor, String marca, Long id_cliente) {
        this.id_veiculo = id_veiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.id_cliente = id_cliente;
    }

    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
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

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }
}
