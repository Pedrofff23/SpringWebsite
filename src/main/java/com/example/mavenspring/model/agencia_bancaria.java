package com.example.mavenspring.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
@Entity
@Table(name="agencia_bancaria")
public class agencia_bancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private Integer id_banco;

    private String endereco;

    private BigInteger  fone;

    private Integer tipo;
    private BigInteger fone1;
    private Integer tipo1;


    private String agencia;

    private String nome_agencia;

    @Enumerated(EnumType.STRING)
    private StatusAgencia statusAgencia;

    public agencia_bancaria() { }

    public agencia_bancaria(Integer id_banco, String endereco, BigInteger fone,
                            Integer tipo, BigInteger fone1, Integer tipo1, String agencia, String nome_agencia, StatusAgencia statusAgencia) {
        this.id_banco = id_banco;
        this.endereco = endereco;
        this.fone = fone;
        this.tipo = tipo;
        this.fone1 = fone1;
        this.tipo1 = tipo1;
        this.agencia = agencia;
        this.nome_agencia = nome_agencia;
        this.statusAgencia = statusAgencia;
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

    public StatusAgencia getStatusAgencia() {
        return statusAgencia;
    }

    public void setStatusAgencia(StatusAgencia statusAgencia) {
        this.statusAgencia = statusAgencia;
    }
}
