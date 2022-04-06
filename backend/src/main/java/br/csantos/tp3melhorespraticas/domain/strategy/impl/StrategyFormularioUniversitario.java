package br.csantos.tp3melhorespraticas.domain.strategy.impl;

import br.csantos.tp3melhorespraticas.domain.Faculdade;
import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;
import br.csantos.tp3melhorespraticas.domain.strategy.Strategy;
import br.csantos.tp3melhorespraticas.domain.strategy.StrategyResponse;
import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioUniversitario;

public class StrategyFormularioUniversitario implements Strategy {

    @Override
    public StrategyResponse execute(FormularioMatricula formularioMatricula) {
        return new StrategyResponse(new FormularioUniversitario(formularioMatricula), new Faculdade());
    }
}
