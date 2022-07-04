package com.example.mavenspring.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name="banco")
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String nome;
    private String numero;
    @Enumerated(EnumType.STRING)
    private StatusBanco statusBanco;

    public Banco() { }

    public Banco(@NonNull String nome, String numero, StatusBanco statusBanco) {
        this.nome = nome;
        this.numero = numero;
        this.statusBanco = statusBanco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public StatusBanco getStatusBanco() {
        return statusBanco;
    }

    public void setStatusBanco(StatusBanco statusBanco) {
        this.statusBanco = statusBanco;
    }
}
