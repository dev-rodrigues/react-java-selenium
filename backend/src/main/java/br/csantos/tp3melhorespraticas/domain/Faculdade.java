package br.csantos.tp3melhorespraticas.domain;

import br.csantos.tp3melhorespraticas.domain.student.Aluno;
import br.csantos.tp3melhorespraticas.domain.student.Universitario;
import br.csantos.tp3melhorespraticas.domain.student.formularios.Formulario;
import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioUniversitario;
import br.csantos.tp3melhorespraticas.domain.factory.InstituicaoDeEnsino;

public class Faculdade extends InstituicaoDeEnsino {

    @Override
    public Aluno preencherFormulario(Formulario formularioMatricula) {
        var formulario = (FormularioUniversitario) formularioMatricula;
        return new Universitario(formulario);
    }
}
