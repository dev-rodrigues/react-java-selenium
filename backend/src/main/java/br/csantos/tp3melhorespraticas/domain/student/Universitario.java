package br.csantos.tp3melhorespraticas.domain.student;

import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioUniversitario;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.Objects;

public class Universitario implements Aluno {

    private Long id;
    private String nome;
    private Date nascimento;

    public Universitario() {
    }

    public Universitario(@NonNull FormularioUniversitario formularioUniversitario) {
        this.nome = Objects.requireNonNull(formularioUniversitario.getNome());
        this.nascimento = Objects.requireNonNull(formularioUniversitario.geNascimento());
    }

    @Override
    public void matricular() {
        System.out.println("Matriculando universitário");
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
