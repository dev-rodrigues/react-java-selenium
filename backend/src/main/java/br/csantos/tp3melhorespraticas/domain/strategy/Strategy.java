package br.csantos.tp3melhorespraticas.domain.strategy;

import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;

public interface Strategy {

    StrategyResponse execute(FormularioMatricula formularioMatricula);
}
