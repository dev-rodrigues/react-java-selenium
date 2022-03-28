package br.csantos.tp3melhorespraticas.domain;

import br.csantos.tp3melhorespraticas.domain.student.Aluno;
import br.csantos.tp3melhorespraticas.domain.student.Primario;
import br.csantos.tp3melhorespraticas.domain.student.formularios.Formulario;
import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioPrimario;
import br.csantos.tp3melhorespraticas.domain.factory.InstituicaoDeEnsino;

public class Escola extends InstituicaoDeEnsino {

    @Override
    public Aluno preencherFormulario(Formulario formularioMatricula) {
        var formaulario = (FormularioPrimario) formularioMatricula;
        return new Primario(formaulario);
    }
}
