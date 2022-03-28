package br.csantos.tp3melhorespraticas.transportlayer.output;

import java.util.Date;

public class MatriculasResponse {

    private Long id;
    private String matricula;
    private String nome;
    private Date nascimento;
    private String responsavel;

    public MatriculasResponse(Long id, String matricula, String nome, Date nascimento, String responsavel) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.nascimento = nascimento;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
