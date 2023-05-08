package com.cadastrousuariodemo.model;

import com.cadastrousuariodemo.validation.Adulto;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Usuario {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Nome não pode ser vazio")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Nome deve conter apenas letras e números")
    private String nome;

    @Column(nullable = false, unique = true)
    @Email(message = "E-mail inválido")
    @Pattern(regexp = "^([a-zA-Z0-9._%+-]+)@(gmail|hotmail|outlook|yahoo)\\.(com|com.br|net|org|co)$", message = "E-mail deve ser de um provedor conhecido (gmail, hotmail, outlook, yahoo)")
    private String email;

    @Column(nullable = false)
    @Past
    @NotNull(message = "Data de nascimento é obrigatória")
    @Adulto(message = "Usuário deve ser maior de 18 anos")
    private LocalDate dataNascimento;

    @Column(nullable = false)
    @NotEmpty(message = "Endereço não pode ser vazio")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Endereço deve conter apenas letras e números")
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Habilidade> habilidades;

    // Construtores
    public Usuario() {
    }

    public Usuario(String nome, String email, LocalDate dataNascimento, String endereco, List<Habilidade> habilidades) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.habilidades = habilidades;
    }

    // Getters e Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    // Métodos

    /**
     * Verifica se dois usuarios são iguais.
     *
     * @param obj a usuario a ser comparada
     * @return true se os usuarios são iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(dataNascimento, usuario.dataNascimento) && Objects.equals(endereco, usuario.endereco) && Objects.equals(habilidades, usuario.habilidades);
    }

    /**
     * Retorna uma representação em string do usuario.
     *
     * @return uma string com id, nome, email, data de nascimento endereço e habilidades
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome='" + nome + '\'' + ", email='" + email + '\'' + ", dataNascimento=" + dataNascimento + ", endereco='" + endereco + '\'' + ", habilidades=" + habilidades + '}';
    }
}
