package com.example.mavenspring.dto;

import com.example.mavenspring.model.Banco;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;

public class RequisicaoNovoBanco {
    @NonNull
    @NotBlank
    private String nome;

    @NonNull
    @NotBlank
    private String numero;

    @Override
    public String toString() {
        return "RequisicaoNovoBanco{" +
                "nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                '}';
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

    public Banco toBanco(){
        Banco banco = new Banco();
        banco.setNome(this.nome);
        banco.setNumero(this.numero);

        return  banco;
    }
}
