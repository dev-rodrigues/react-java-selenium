package br.csantos.tp3melhorespraticas.domain.strategy;

import br.csantos.tp3melhorespraticas.domain.factory.InstituicaoDeEnsino;
import br.csantos.tp3melhorespraticas.domain.student.formularios.Formulario;

public class StrategyResponse {

    private final Formulario formulario;
    private final InstituicaoDeEnsino instituicaoDeEnsino;

    public StrategyResponse(Formulario formulario, InstituicaoDeEnsino instituicaoDeEnsino) {
        this.formulario = formulario;
        this.instituicaoDeEnsino = instituicaoDeEnsino;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public InstituicaoDeEnsino getInstituicaoDeEnsino() {
        return instituicaoDeEnsino;
    }
}
