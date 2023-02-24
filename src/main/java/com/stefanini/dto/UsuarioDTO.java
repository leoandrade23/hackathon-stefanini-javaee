package com.stefanini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.model.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioDTO {

    private Long id;
    @NotBlank(message = "Nome não pode ser nulo")
    @Size(max = 50, message = "Nome pode ter no máximo 50 caracteres")
    private String nome;
    @NotBlank(message = "Login não pode ser nulo")
    @Size(min = 5, max = 20, message = "Login deve ter entre 5 a 20 caracteres")
    private String login;
    @NotBlank(message = "E-mail não pode ser nulo")
    @Size(min = 10, message = "Email deve ter no mínimo 10 caracteres")
    private String email;
    @NotBlank(message = "Senha não pode ser nulo")
    @Size(min = 4, max = 10, message = "Senha deve ter entre 4 a 10 caracteres")
    private String senha;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataAtualizacao;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.email = usuario.getEmail();
        this.dataNascimento = usuario.getDataNascimento();
        this.dataCriacao = usuario.getDataCriacao();
        this.dataAtualizacao = usuario.getDataAtualizacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
