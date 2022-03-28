package br.csantos.tp3melhorespraticas.domain.factory;

import br.csantos.tp3melhorespraticas.domain.student.Aluno;
import br.csantos.tp3melhorespraticas.domain.student.formularios.Formulario;

public abstract class InstituicaoDeEnsino {

    public void matricular(Formulario formularioMatricula) {
        Aluno aluno = preencherFormulario(formularioMatricula);
        aluno.matricular();
    }

    public abstract Aluno preencherFormulario(Formulario formularioMatricula);
}
