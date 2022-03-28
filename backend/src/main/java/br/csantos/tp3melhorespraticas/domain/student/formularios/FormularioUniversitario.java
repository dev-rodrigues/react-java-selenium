package br.csantos.tp3melhorespraticas.domain.student.formularios;

import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;

import java.util.Date;

public class FormularioUniversitario implements Formulario {

    private String nome;
    private Date nascimento;

    public FormularioUniversitario(FormularioMatricula formularioMatricula) {
        this.nome = formularioMatricula.getNome();
        this.nascimento = formularioMatricula.getNascimento();
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Date geNascimento() {
        return nascimento;
    }
}
