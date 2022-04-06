package br.csantos.tp3melhorespraticas.interactor;

import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;
import br.csantos.tp3melhorespraticas.domain.factory.InstituicaoDeEnsino;
import br.csantos.tp3melhorespraticas.domain.strategy.Context;
import br.csantos.tp3melhorespraticas.domain.student.Aluno;
import br.csantos.tp3melhorespraticas.domain.student.formularios.Formulario;
import br.csantos.tp3melhorespraticas.port.InstituicaoPort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class EfetuarMatricula {

    private Formulario formulario;
    private InstituicaoDeEnsino instituicaoDeEnsino;
    private final InstituicaoPort instituicaoPort;

    public EfetuarMatricula(InstituicaoPort instituicaoPort) {
        this.instituicaoPort = instituicaoPort;
    }

    public Aluno executar(@NonNull FormularioMatricula formularioMatricula) {

        var context = Context.obterFormulario(formularioMatricula);
        this.formulario = context.getFormulario();
        this.instituicaoDeEnsino = context.getInstituicaoDeEnsino();

        var preMatriculado = instituicaoDeEnsino.preencherFormulario(formulario);
        return instituicaoPort.salvar(preMatriculado);
    }
}
