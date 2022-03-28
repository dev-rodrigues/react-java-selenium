package br.csantos.tp3melhorespraticas.domain.student;

import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioPrimario;
import org.springframework.lang.NonNull;

import java.util.Date;

public class Primario implements Aluno {

    private Long id;
    private String nome;
    private String responsavel;
    private Date nascimento;

    public Primario() {
    }

    public Primario(@NonNull FormularioPrimario formularioPrimario) {
        this.nome = formularioPrimario.getNome();
        this.responsavel = formularioPrimario.getResponsavel();
        this.nascimento = formularioPrimario.geNascimento();
    }

    @Override
    public void matricular() {
        System.out.println("Matriculando aluno primario");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
