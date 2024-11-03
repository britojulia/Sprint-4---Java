package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientesTO {

    @NotNull
    private String cpf;
    @NotBlank
    private String nome;
    private Long telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;

    public ClientesTO() {
    }

    public ClientesTO(String cpf, String nome, Long telefone, String email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public @NotNull String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank String senha) {
        this.senha = senha;
    }
}

