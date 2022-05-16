package com.example.mavenspring.dto;

import com.example.mavenspring.model.Banco;

public class RequisicaoNovoBanco {
    private String nome;
    private String numero;

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

    public Banco toBanco(){
        Banco banco = new Banco();
        banco.setNome(this.nome);
        banco.setNumero(this.numero);

        return  banco;
    }
}
