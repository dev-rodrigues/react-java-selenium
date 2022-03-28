package br.csantos.tp3melhorespraticas.interactor;

import br.csantos.tp3melhorespraticas.domain.Escola;
import br.csantos.tp3melhorespraticas.domain.Faculdade;
import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;
import br.csantos.tp3melhorespraticas.domain.student.Aluno;
import br.csantos.tp3melhorespraticas.domain.student.formularios.Formulario;
import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioPrimario;
import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioUniversitario;
import br.csantos.tp3melhorespraticas.domain.factory.InstituicaoDeEnsino;
import br.csantos.tp3melhorespraticas.port.InstituicaoPort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class EfetuarMatricula {

    private InstituicaoDeEnsino instituicaoDeEnsino;
    private final InstituicaoPort instituicaoPort;
    private Formulario formulario;

    public EfetuarMatricula(InstituicaoPort instituicaoPort) {
        this.instituicaoPort = instituicaoPort;
    }

    public Aluno executar(@NonNull FormularioMatricula formularioMatricula) {

        var idadeDoAluno = CalcularIdade.executar(formularioMatricula.getNascimento());

        if (idadeDoAluno < 18) {
            this.instituicaoDeEnsino = new Escola();
            this.formulario = new FormularioPrimario(formularioMatricula);

        } else {
            this.instituicaoDeEnsino = new Faculdade();
            this.formulario = new FormularioUniversitario(formularioMatricula);
        }

        var preMatriculado = instituicaoDeEnsino.preencherFormulario(formulario);
        return instituicaoPort.salvar(preMatriculado);
    }
}
