package br.csantos.tp3melhorespraticas.domain.strategy.impl;

import br.csantos.tp3melhorespraticas.domain.Escola;
import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;
import br.csantos.tp3melhorespraticas.domain.strategy.Strategy;
import br.csantos.tp3melhorespraticas.domain.strategy.StrategyResponse;
import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioPrimario;

public class StrategyFormularioPrimario implements Strategy {

    @Override
    public StrategyResponse execute(FormularioMatricula formularioMatricula) {
        return new StrategyResponse(new FormularioPrimario(formularioMatricula), new Escola());
    }
}
