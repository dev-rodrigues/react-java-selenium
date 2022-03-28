package br.csantos.tp3melhorespraticas.port;

import br.csantos.tp3melhorespraticas.domain.student.Aluno;
import br.csantos.tp3melhorespraticas.domain.student.Primario;
import br.csantos.tp3melhorespraticas.domain.student.Universitario;

import java.util.List;

public interface InstituicaoPort {

    Aluno salvar(Aluno aluno);

    List<Primario> consultarPrimarios();

    List<Universitario> consultarUniversitarios();
}
