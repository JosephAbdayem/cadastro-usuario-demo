package com.cadastrousuariodemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Habilidade {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

    @Column(nullable = false)
    @NotEmpty(message = "Descrição não pode ser vazia")
    private String descricao;

    // Construtores
    public Habilidade() {
    }

    public Habilidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Métodos

    /**
     * Compara se duas habilidades são iguais.
     *
     * @param o o objeto a ser comparado
     * @return true se as habilidades são iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Habilidade habilidade = (Habilidade) o;

        if (!id.equals(habilidade.id)) return false;
        if (!nome.equals(habilidade.nome)) return false;
        return descricao.equals(habilidade.descricao);
    }

    /**
     * Retorna uma representação em string da habilidade.
     *
     * @return uma string com nome e descrição da habilidade
     */
    @Override
    public String toString() {
        return "Habilidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
