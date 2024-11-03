package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ChamadoTO {

    @NotNull private Long id_chamado;
    private String descricao;
    @NotNull private String tipo_servico;
    @NotNull @FutureOrPresent
    private LocalDate data_chamado;
    private String cpf;

    public ChamadoTO() {
    }

    public ChamadoTO(String cpf, LocalDate data_chamado, String tipo_servico, String descricao, Long id_chamado) {
        this.cpf = cpf;
        this.data_chamado = data_chamado;
        this.tipo_servico = tipo_servico;
        this.descricao = descricao;
        this.id_chamado = id_chamado;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
