package br.csantos.tp3melhorespraticas.interactor;

import br.csantos.tp3melhorespraticas.domain.valueObjects.Matricula;
import br.csantos.tp3melhorespraticas.port.InstituicaoPort;
import br.csantos.tp3melhorespraticas.transportlayer.output.MatriculasResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultarMatriculas {

    private final InstituicaoPort instituicaoPort;

    public ConsultarMatriculas(InstituicaoPort instituicaoPort) {
        this.instituicaoPort = instituicaoPort;
    }

    public List<MatriculasResponse> executar() {
        var response = new ArrayList<MatriculasResponse>();
        var primarios = this.instituicaoPort.consultarPrimarios();
        var universitarios = this.instituicaoPort.consultarUniversitarios();

        primarios.forEach(it -> {
            response.add(new MatriculasResponse(it.getId(), Matricula.PRIMARIO.name(), it.getNome(), it.getNascimento(), it.getNome()));
        });

        universitarios.forEach(it -> {
            response.add(new MatriculasResponse(it.getId(), Matricula.UNIVERSITARIO.name(), it.getNome(), it.getNascimento(), it.getNome()));
        });

        return response;
    }
}
