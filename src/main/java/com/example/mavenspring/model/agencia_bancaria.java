package com.example.mavenspring.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
@Entity
public class agencia_bancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @NonNull
    private Integer id_banco;
    private String endereco;
    private BigInteger  fone;
    private Integer tipo;
    private BigInteger fone1;
    private Integer tipo1;
    @NotBlank
    @NonNull
    private String agencia;
    private String nome_agencia;

    public agencia_bancaria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_banco() {
        return id_banco;
    }

    public void setId_banco(Integer id_banco) {
        this.id_banco = id_banco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigInteger getFone() {
        return fone;
    }

    public void setFone(BigInteger fone) {
        this.fone = fone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public BigInteger getFone1() {
        return fone1;
    }

    public void setFone1(BigInteger fone1) {
        this.fone1 = fone1;
    }

    public Integer getTipo1() {
        return tipo1;
    }

    public void setTipo1(Integer tipo1) {
        this.tipo1 = tipo1;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNome_agencia() {
        return nome_agencia;
    }

    public void setNome_agencia(String nome_agencia) {
        this.nome_agencia = nome_agencia;
    }
}
