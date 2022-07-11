package com.example.mavenspring.dto;

import com.example.mavenspring.model.Banco;
import com.example.mavenspring.model.StatusAgencia;
import com.example.mavenspring.model.agencia_bancaria;
import org.springframework.lang.NonNull;
import javax.validation.constraints.NotBlank;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class RequisicaoNovaAgencia {
    @NotNull
    private Integer id_banco;

    private String endereco;
    @NotNull
    private BigInteger fone;
    @NotNull
    private Integer tipo;
    @NotNull
    private BigInteger fone1;
    @NotNull
    private Integer tipo1;

    @NotBlank
    @NonNull
    private String agencia;

    @NotBlank
    @NonNull
    private String nome_agencia;

    private StatusAgencia statusAgencia;

    public agencia_bancaria toAgencia(){
        agencia_bancaria Agencia = new agencia_bancaria();
        Agencia.setId_banco(this.id_banco);
        Agencia.setEndereco(this.endereco);
        Agencia.setFone(this.fone);
        Agencia.setTipo(this.tipo);
        Agencia.setFone1(this.fone1);
        Agencia.setTipo1(this.tipo1);
        Agencia.setStatusAgencia(this.statusAgencia);
        Agencia.setNome_agencia(this.nome_agencia);
        Agencia.setAgencia(this.agencia);

        return Agencia;
    }

    public void fromAgencia(agencia_bancaria agencia_bancaria){
        this.id_banco = agencia_bancaria.getId_banco();
        this.endereco = agencia_bancaria.getEndereco();
        this.fone = agencia_bancaria.getFone();
        this.tipo = agencia_bancaria.getTipo();
        this.fone1 = agencia_bancaria.getFone1();
        this.tipo1 = agencia_bancaria.getTipo1();
        this.statusAgencia = agencia_bancaria.getStatusAgencia();
        this.nome_agencia = agencia_bancaria.getNome_agencia();
        this.agencia = agencia_bancaria.getAgencia();
    }

    public agencia_bancaria toAgencia(agencia_bancaria agencia_bancaria){
        agencia_bancaria.setId_banco(this.id_banco);
        agencia_bancaria.setEndereco(this.endereco);
        agencia_bancaria.setFone(this.fone);
        agencia_bancaria.setTipo(this.tipo);
        agencia_bancaria.setFone1(this.fone1);
        agencia_bancaria.setTipo1(this.tipo1);
        agencia_bancaria.setNome_agencia(this.nome_agencia);
        agencia_bancaria.setAgencia(this.agencia);
        return agencia_bancaria;
    }

    @NonNull
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

    @NonNull
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

    @NonNull
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(@NonNull String agencia) {
        this.agencia = agencia;
    }

    @NonNull
    public String getNome_agencia() {
        return nome_agencia;
    }

    public void setNome_agencia(@NonNull String nome_agencia) {
        this.nome_agencia = nome_agencia;
    }

    public StatusAgencia getStatusAgencia() {
        return statusAgencia;
    }

    public void setStatusAgencia(StatusAgencia statusAgencia) {
        this.statusAgencia = statusAgencia;
    }

    @Override
    public String toString() {
        return "RequisicaoNovaAgencia{" +
                "id_banco=" + id_banco +
                ", endereco='" + endereco + '\'' +
                ", fone=" + fone +
                ", tipo=" + tipo +
                ", fone1=" + fone1 +
                ", tipo1=" + tipo1 +
                ", agencia='" + agencia + '\'' +
                ", nome_agencia='" + nome_agencia + '\'' +
                ", statusAgencia=" + statusAgencia +
                '}';
    }
}
