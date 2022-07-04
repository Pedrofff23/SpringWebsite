package com.example.mavenspring.dto;

import com.example.mavenspring.model.Banco;
import com.example.mavenspring.model.StatusBanco;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//Data transfer Objet = DTO
public class RequisicaoNovoBanco {
    @NonNull
    @NotBlank
    private String nome;
    @NonNull
    @NotBlank
    private String numero;
    private StatusBanco statusBanco;


    public Banco toBanco(){
        Banco banco = new Banco();
        banco.setNome(this.nome);
        banco.setNumero(this.numero);
        banco.setStatusBanco(this.statusBanco);

        return banco;
    }

    public void fromBanco(Banco banco){
        this.nome = banco.getNome();
        this.numero = banco.getNumero();
        this.statusBanco = banco.getStatusBanco();
    }

    public Banco toBanco(Banco banco){
        banco.setNome(this.nome);
        banco.setNumero(this.numero);

        return banco;
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

    @Override
    public String toString() {
        return "RequisicaoNovoBanco{" +
                "nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                ", statusBanco=" + statusBanco +
                '}';
    }
}
