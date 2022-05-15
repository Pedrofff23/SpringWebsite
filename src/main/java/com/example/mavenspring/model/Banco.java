package com.example.mavenspring.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @NonNull
    private Integer nome;
    @NotBlank
    @NonNull
    private Integer numero;

    public Banco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getNome() {
        return nome;
    }

    public void setNome(@NonNull Integer nome) {
        this.nome = nome;
    }

    @NonNull
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(@NonNull Integer numero) {
        this.numero = numero;
    }
}
