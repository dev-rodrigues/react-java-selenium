package br.csantos.tp3melhorespraticas.domain.student.formularios;

import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.Objects;

public class FormularioPrimario implements Formulario {

    private String nome;
    private String responsavel;
    private Date nascimento;

    public FormularioPrimario(FormularioMatricula formularioMatricula) {
        this.nome = Objects.requireNonNull(formularioMatricula.getNome());
        this.responsavel = Objects.requireNonNull(formularioMatricula.getResponsavel());
        this.nascimento = Objects.requireNonNull(formularioMatricula.getNascimento());
    }

    public FormularioPrimario(@NonNull String nome, @NonNull String responsavel, @NonNull Date nascimento) {
        this.nome = Objects.requireNonNull(nome);
        this.responsavel = Objects.requireNonNull(responsavel);
        this.nascimento = Objects.requireNonNull(nascimento);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Date geNascimento() {
        return nascimento;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
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