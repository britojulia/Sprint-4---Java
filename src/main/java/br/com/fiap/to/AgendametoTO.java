package br.com.fiap.to;

import java.time.LocalDate;

public class AgendametoTO {

    private Long id_agendamento;
    private LocalDate data_agendamento;
    private String tipo_serviço;
    private String status;
    private Long id_cliente;
    private Long id_veiculo;

    public AgendametoTO() {
    }

    public AgendametoTO(Long id_agendamento, LocalDate data_agendamento, String tipo_serviço, String status, Long id_cliente, Long id_veiculo) {
        this.id_agendamento = id_agendamento;
        this.data_agendamento = data_agendamento;
        this.tipo_serviço = tipo_serviço;
        this.status = status;
        this.id_cliente = id_cliente;
        this.id_veiculo = id_veiculo;
    }

    public Long getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(Long id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public LocalDate getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(LocalDate data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public String getTipo_serviço() {
        return tipo_serviço;
    }

    public void setTipo_serviço(String tipo_serviço) {
        this.tipo_serviço = tipo_serviço;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }
}
