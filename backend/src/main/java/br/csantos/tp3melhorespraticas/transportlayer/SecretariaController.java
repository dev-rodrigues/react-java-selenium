package br.csantos.tp3melhorespraticas.transportlayer;

import br.csantos.tp3melhorespraticas.domain.student.Primario;
import br.csantos.tp3melhorespraticas.interactor.ConsultarMatriculas;
import br.csantos.tp3melhorespraticas.interactor.EfetuarMatricula;
import br.csantos.tp3melhorespraticas.transportlayer.input.FormularioMatriculaInput;
import br.csantos.tp3melhorespraticas.transportlayer.mappers.FormularioMapper;
import br.csantos.tp3melhorespraticas.transportlayer.output.MatriculasResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/secretaria")
public class SecretariaController {

    private final EfetuarMatricula efetuarMatricula;
    private final ConsultarMatriculas consultarMatriculas;
    private final FormularioMapper mapper = Mappers.getMapper(FormularioMapper.class);

    public SecretariaController(EfetuarMatricula efetuarMatricula, ConsultarMatriculas consultarMatriculas) {
        this.efetuarMatricula = efetuarMatricula;
        this.consultarMatriculas = consultarMatriculas;
    }

    @GetMapping("/")
    public ResponseEntity<List<MatriculasResponse>> listarMatriculas() {
        var response = consultarMatriculas.executar();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> matricular(@RequestBody FormularioMatriculaInput formularioMatricula) {
        Objects.requireNonNull(formularioMatricula);
        var formulario = mapper.map(formularioMatricula);
        var response  = efetuarMatricula.executar(formulario);

        var map = new HashMap<String, String>();
        map.put("tipo de aluno", response instanceof Primario ? "primário" : "universitário");

        return ResponseEntity.ok().body(map);
    }
}
