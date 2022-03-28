package br.csantos.tp3melhorespraticas.domain;


import java.util.Date;

public class FormularioMatricula {

    private String nome;
    private Date nascimento;
    private String responsavel;

    public FormularioMatricula() {
    }

    public FormularioMatricula(String nome, Date nascimento, String responsavel) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
