package br.com.fiap.to;

import java.time.LocalDate;

public class ChamadoTO {

    private Long id_chamado;
    private String descricao;
    private String tipo_servico;
    private LocalDate data_chamado;
    private Long id_cliente;

    public ChamadoTO() {
    }

    public ChamadoTO(Long id_chamado, String descricao, String tipo_servico, LocalDate data_chamado, Long id_cliente) {
        this.id_chamado = id_chamado;
        this.descricao = descricao;
        this.tipo_servico = tipo_servico;
        this.data_chamado = data_chamado;
        this.id_cliente = id_cliente;
    }

    public Long getId_chamado() {
        return id_chamado;
    }

    public void setId_chamado(Long id_chamado) {
        this.id_chamado = id_chamado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(String tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    public LocalDate getData_chamado() {
        return data_chamado;
    }

    public void setData_chamado(LocalDate data_chamado) {
        this.data_chamado = data_chamado;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }
}
