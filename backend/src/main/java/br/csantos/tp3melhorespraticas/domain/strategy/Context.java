package br.csantos.tp3melhorespraticas.domain.strategy;

import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;
import br.csantos.tp3melhorespraticas.domain.strategy.impl.StrategyFormularioPrimario;
import br.csantos.tp3melhorespraticas.domain.strategy.impl.StrategyFormularioUniversitario;
import br.csantos.tp3melhorespraticas.interactor.CalcularIdade;

public class Context {

    public static StrategyResponse obterFormulario(FormularioMatricula formularioMatricula) {

        var idadeDoAluno = CalcularIdade.executar(formularioMatricula.getNascimento());

        if (idadeDoAluno < 18) {
            Strategy strategy = new StrategyFormularioPrimario();
            return strategy.execute(formularioMatricula);
        }

        Strategy strategy = new StrategyFormularioUniversitario();
        return strategy.execute(formularioMatricula);
    }
}
