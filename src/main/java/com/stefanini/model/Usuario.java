package com.stefanini.model;

import com.stefanini.dto.UsuarioDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    @NotBlank(message = "Nome do Usuário não pode ser nulo")
    private String nome;

    @Column(name = "login", length = 20, nullable = false, unique = true)
    @NotBlank(message = "Login não pode ser nulo")
    @Size(min = 5, max = 20, message = "Login deve ter entre 5 a 20 caracteres")
    private String login;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "E-mail não pode ser nulo")
    @Size(min = 10, message = "E-mail deve ter no mínimo 10 caracteres")
    private String email;

    @Column(name = "senha", nullable = false)
    @Size(min = 4, max = 10, message = "Senha deve ter entre 4 a 10 caracteres")
    private String senha;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Usuario() {

    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.getId();
        this.nome = usuarioDTO.getNome();
        this.login = usuarioDTO.getLogin();
        this.senha = usuarioDTO.getSenha();
        this.email = usuarioDTO.getEmail();
        this.dataNascimento = usuarioDTO.getDataNascimento();
        this.dataCriacao = usuarioDTO.getDataCriacao();
        this.dataAtualizacao = usuarioDTO.getDataAtualizacao();
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
